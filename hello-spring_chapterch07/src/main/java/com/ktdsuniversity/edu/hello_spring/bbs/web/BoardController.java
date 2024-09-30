package com.ktdsuniversity.edu.hello_spring.bbs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ktdsuniversity.edu.hello_spring.bbs.service.BoardService;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.WriteBoardVO;

/**
 * 
 */
@Controller
public class BoardController {
	
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
	 * @return
	 */
	@PostMapping("/board/write")
	public String doCreateNewBoard(@ModelAttribute WriteBoardVO writeBoardVO) {
		
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
	
}
