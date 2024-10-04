package com.ktdsuniversity.edu.hello_spring.bbs.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ktdsuniversity.edu.hello_spring.bbs.service.BoardService;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.ModifyBoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.WriteBoardVO;
import com.ktdsuniversity.edu.hello_spring.common.beans.FileHandler;

/**
 * 
 */
@Controller
public class BoardController {
	
	@Autowired
	private FileHandler fileHandler;

	@Autowired
	private BoardService boardService;

	@GetMapping("/board/list") // http://localhost:8080/board/list로 연결
	public String viewBoardList(Model model) {
		BoardListVO boardListVO = this.boardService.getAllBoard();

		model.addAttribute("boardListVO", boardListVO);

		return "board/boardlist";
	}

	@GetMapping("/board/write")
	public String writeNewBoard() {
		return "board/boardwrite";
	}

	/**
	 * 사용자가 입력한 값을 서버에 전송하기 위한 컨트롤러 메서드.
	 * 
	 * @param writeBoardVO : 사용자가 입력한 값을 담은 VO 객체
	 * @param Model : 사용자가 필수 입력칸을 입력하지 않았을 때 원래 입력했던 값을 다시 보여주기 위해 보여줘야 한다.
	 * @return
	 */
	@PostMapping("/board/write")
	public String doCreateNewBoard(WriteBoardVO writeBoardVO, Model model) {
		
		// 사용자가 필수 입력값을 입력하지 않은 경우.
		if(writeBoardVO.getSubject() == null || writeBoardVO.getSubject().length() == 0) {
			model.addAttribute("error_subject", "제목은 필수 입력값입니다.");
			model.addAttribute("writeBoardVO", writeBoardVO);
			return "board/boardwrite";
		}
		
		if(writeBoardVO.getSubject() != null && writeBoardVO.getSubject().length() < 5) {
			model.addAttribute("error_subject", "제목은 다섯글자 이상 적어주세요.");
			model.addAttribute("writeBoardVO", writeBoardVO);
			return "board/boardwrite";
		}
		
		if(writeBoardVO.getEmail() == null || writeBoardVO.getEmail()=="" ) {
			model.addAttribute("error_subject", "이메일은 필수 입력값입니다.");
			model.addAttribute("writeBoardVO", writeBoardVO);
			return "board/boardwrite";
		}

		System.out.println("게시글 제목: " + writeBoardVO.getSubject());
		System.out.println("이메일 주소:" + writeBoardVO.getEmail());
		System.out.println("게시글 내용: " + writeBoardVO.getContent());

		boolean isSuccess = boardService.createNewBoard(writeBoardVO);

		System.out.println("성공적으로 게시글 등록이 완료되었습니다." + isSuccess);

		return "redirect:/board/list";
	}

	@GetMapping("/board/view") // http://localhost:8080/board/view?id=1
	public String viewOneBoard(@RequestParam int id, Model model) {

		BoardVO boardVO = boardService.getOneBoard(id, true);

		// Model 객체에 boardVO 데이터를 추가한다.
		model.addAttribute("boardVO", boardVO);

		// 파일의 경로이다.
		return "board/boardview";
	}

	@GetMapping("/board/modify/{id}") // http://localhost:8080/board/modify/1
	public String viewBoardModifyPage(@PathVariable int id, Model model) {

		BoardVO boardVO = new BoardVO();
		boardVO = boardService.getOneBoard(id, false);

		model.addAttribute("boardVO", boardVO);

		// 파일의 경로를 전달한다.
		return "board/boardmodify";
	}

	@PostMapping("/board/modify/{id}")
	public String doModifyOneBoard(@PathVariable int id, ModifyBoardVO modifyBoardVO, Model model) {

		modifyBoardVO.setId(id);

		boolean isUpdated = this.boardService.updateOneBoard(modifyBoardVO);

		if (isUpdated) {
			// 성공적으로 수정했다면 수정한 게시글의 상세조회 페이지로 이동시킨다.
			System.out.println("게시글 수정이 정상적으로 작성함.");
			return "redirect:/board/view?id=" + id;

		} else {
			// 사용자가 작성했던 내용을 JSP에 그대로 보내준다.
			// 모델 데이터를 보내줘야한다.
			model.addAttribute("boardVO", modifyBoardVO);
			System.out.println("게시글 수정이 정상적으로 작성되지 않음.");
			return "board/boardmodify";
		}
	}

	@GetMapping("/board/delete/{id}")
	public String deleteOneBoardGet(@PathVariable int id) {
		boolean isDeleted = boardService.deleteOneBoard(id);

		if (isDeleted) {
			System.out.println("게시글 삭제에 성공함.");
			return "redirect:/board/list"; // 게시글 목록 페이지로 리다이렉트
		} else {
			return "redirect:/board/view?id=" + id; // 삭제 실패 시 게시글 상세보기로 리다이렉트
		}
	}

	@GetMapping("/board/file/download/{id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable int id) {

		// 1. 다운로드 할 파일의 이름을 알기 위해 게시글을 조회한다.
		BoardVO boardVO = this.boardService.getOneBoard(id, false);

		return this.fileHandler.downloadFile(boardVO.getFileName(), boardVO.getOriginFileName());
	}

}
