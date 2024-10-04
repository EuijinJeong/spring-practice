package com.ktdsuniversity.edu.hello_spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ktdsuniversity.edu.hello_spring.service.ToDoListService;
import com.ktdsuniversity.edu.hello_spring.vo.ToDoListWriteVO;

@Controller
public class ToDoListController {
	
	@Autowired 
	private ToDoListService toDoListService;
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/todolist/writelist")
	public String renderToDoListForm() {
		return "todolist/todowritelist";
	}

	
	/**
	 * 사용자가 입력한 값을 서버에 전송하기 위한 컨트롤러.
	 * 
	 * @param toDoListWriteVO: 사용자가 입력한 값을 담은 VO 객체.
	 * @param model: 사용자가 필수 입력칸을 입력하지 않았을 때 원래 입력했던 값을 다시 보여주기 위해 보여줘야 한다.
	 */
	@PostMapping("/todolist/writelist")
	public String writeToDoList(ToDoListWriteVO toDoListWriteVO, Model model) {
		
		// 유효성 검사를 한다.
		if(toDoListWriteVO.getSubject() == null || toDoListWriteVO.getSubject()=="") {
			model.addAttribute("error_subject", "제목은 필수 입력값입니다.");
			model.addAttribute("toDoListWriteVO", toDoListWriteVO);
			return "todolist/todowritelist";
		}
		
		if(toDoListWriteVO.getDeadLine() == null || toDoListWriteVO.getDeadLine() =="") {
			model.addAttribute("error_subject", "완료일 입력은 필수 입력란입니다.");
			model.addAttribute("toDoListWriteVO", toDoListWriteVO);
			return "todolist/todowritelist";
		}

		boolean isCreated = toDoListService.insertNewToDoList(toDoListWriteVO);
		
		if(isCreated) {
			System.out.println("성공적으로 TODO LIST가 등록되었습니다.");
			return "redirect:/todolist/list";
		}
		else {
			throw new IllegalArgumentException("알 수 없는 시스템 오류로 TODO LIST 생성에 실패했습니다. 다시 시도해주세요.");
		}
		
	}
}
