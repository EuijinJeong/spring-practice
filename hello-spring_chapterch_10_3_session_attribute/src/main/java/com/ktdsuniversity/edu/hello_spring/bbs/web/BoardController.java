package com.ktdsuniversity.edu.hello_spring.bbs.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ktdsuniversity.edu.hello_spring.bbs.service.BoardService;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.ModifyBoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.WriteBoardVO;
import com.ktdsuniversity.edu.hello_spring.common.beans.FileHandler;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

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
	 * @param BindingResult: 
	 * @param loginMemberVO: 
	 * @return
	 */
	@PostMapping("/board/write")
	public String doCreateNewBoard(@Valid WriteBoardVO writeBoardVO , 
			BindingResult bindingResult,
			Model model, 
			@SessionAttribute(value = "_LOGIN_USER_", required = false) MemberVO loginMemberVO) {
		
		HttpServletRequest request = 
				((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();
		writeBoardVO.setIp(request.getRemoteAddr());
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("writeBoardVO", writeBoardVO);
			return "board/boardwrite";
		}
		
//		MemberVO memberVO = (MemberVO) session.getAttribute("_LOGIN_USER_"); - > @SessionAttribute("_LOGIN_USER_") MemberVO loginMemberVO
		// 컨트롤러에서만 이런식으로 하고 나머지는 원래 하던대로 HttpSession을 사용해서 해야함.
		
		/**
		 * session에서 가져온 MemberVO 인스턴스는 로그인 여부에 따라 NULL 혹은 인스턴스가 할당되어있다.
		 * memberVO가 NULL이라면, 로그인이 안되어있는 것으로 로그인을 유도시켜야 한다.
		 */
		
		if(loginMemberVO == null) {
			return "redirect:/member/login";
		}
		
		writeBoardVO.setEmail(loginMemberVO.getEmail());
		
		boolean isCreate = this.boardService.createNewBoard(writeBoardVO);
		System.out.println("게시글 등록 결과:" + isCreate);
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
	public String doModifyOneBoard(@PathVariable int id, 
			@Valid ModifyBoardVO modifyBoardVO,
			BindingResult bindingResult,
			Model model,
			@SessionAttribute(value = "_LOGIN_USER_", required = false) MemberVO loginMemberVO) {

		modifyBoardVO.setId(id);
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("modifyBoardVO", modifyBoardVO);
			return "board/boardmodify";
		}
		
		if(loginMemberVO == null) {
			return "redirect:/member/login";
		}

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
