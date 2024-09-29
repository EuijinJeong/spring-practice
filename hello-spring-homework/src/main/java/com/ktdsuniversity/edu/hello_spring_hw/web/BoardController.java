package com.ktdsuniversity.edu.hello_spring_hw.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniversity.edu.hello_spring_hw.service.BoardService;
import com.ktdsuniversity.edu.hello_spring_hw.vo.BoardListVo;
import com.ktdsuniversity.edu.hello_spring_hw.vo.BoardVo;
import com.ktdsuniversity.edu.hello_spring_hw.vo.WriteNewBoardVo;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	/**
	 * 게시글 목록보는 요청을 처리하는 메서드
	 * 
	 * @return: 게시글 목록 화면
	 */
	@GetMapping("/board/list")
	public ModelAndView viewBoardList() {
		
		BoardListVo boardListVo = new BoardListVo();
		
		boardListVo = boardService.getAllBoard();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board/board_mainpage");
		modelAndView.addObject("boardList", boardListVo);
		
		
		return modelAndView;
	}
	
	/**
	 * 게시글 작성 화면을 컨트롤하는 메서드.
	 * 
	 * @return: 게시글 작성 화면.
	 */
	@GetMapping("/board/write")
	public String viewBoardWritePage() {
		return "/board/boardwrite";
	}
	
	/**
	 * 게시글 작성 결과를 보여주는 요청을 컨트롤하는 메서드.
	 * 
	 * @param writeNewBoardVo: 사용자가 입력한 게시글의 정보를 담은 객체
	 * @return: 게시글 등록 완료 화면.
	 */
	@PostMapping("/board/writeresult")
	public ModelAndView doBoardWrite(@ModelAttribute WriteNewBoardVo writeNewBoardVo) {
		
		// 객체 생성
		ModelAndView modelAndView = new ModelAndView();
		
		// 게시글 등록 서비스로직 호출
		boolean isSuccess = boardService.createNewBoard(writeNewBoardVo);
		
		if(isSuccess) {
			modelAndView.setViewName("board/boardwrite_result");
			modelAndView.addObject("board", writeNewBoardVo);
			modelAndView.addObject("message", "게시글이 성공적으로 등록되었습니다.");
		} else {
			modelAndView.setViewName("board/boardwrite_result");
			modelAndView.addObject("message", "게시글 등록에 실패했습니다. 다시 시도해 주세요.");
		}
		

		return modelAndView;
	}
	
}
