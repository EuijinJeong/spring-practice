package com.ktdsuniversity.edu.hello_spring.todolist.web;

import com.ktdsuniversity.edu.hello_spring.todolist.service.ToDoListService;
import com.ktdsuniversity.edu.hello_spring.todolist.vo.ToDoListVO;
import com.ktdsuniversity.edu.hello_spring.todolist.vo.ToDoListWriteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class ToDoListController {
	
	@Autowired 
	private ToDoListService toDoListService;
	
	@GetMapping("/todolist/writelist")
	public String renderToDoListForm() {
		return "todolist/todowritelist";
	}

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
	
	// todolist보기 관련 컨트롤러.
	@GetMapping("/todolist/list")
	public String getAllToDoList(Model model) {
		
		ToDoListVO toDoListVO = new ToDoListVO();
		toDoListVO = toDoListService.selectAllToDoList();
		
		if(toDoListVO == null) {
			throw new IllegalArgumentException("알 수 없는 시스템 오류로 TODO LIST 목록을 가져오는데 실패했습니다.");
		}
		
		System.out.println("Retrieved ToDo List: " + toDoListVO.getToDoList());
		
		model.addAttribute("toDoList", toDoListVO.getToDoList());
		
		return "todolist/todolist";
	}
	
	// 수정 관련한 컨트롤러.
	@GetMapping("/todolist/modify/{id}")
	public String getModifyIsFinished(@PathVariable int id) {
		// jsp 경로를 return함.
		return "redirect:/todolist/list"; 
	}
	
	@PostMapping("/todolist/modify/{id}")
	public String postModifyIsFinished(@PathVariable int id) {
		
		boolean isModified = toDoListService.updateIsFinished(id);
		
		if(isModified) {
			System.out.println("성공적으로 수정되었습니다.");
			return "redirect:/todolist/list";
		} else {
			return "redirect:/todolist/list";
		}
	}
	
	@GetMapping("/todolist/delete/{id}")
	public String getDeleteToDoList(@PathVariable int id) {
		return "redirect:/todolist/list";
	}
	
	@PostMapping("/todolist/delete/{id}")
	public String postDeleteToDoList(@PathVariable int id) {
		boolean isDeleted = toDoListService.deleteToDoList(id);
		
		if(isDeleted) {
			System.out.println("성공적으로 삭제되었습니다.");
			return "redirect:/todolist/list";
		} else {
			System.out.println("삭제에 실패했습니다.");
			return "redirect:/todolist/list";
		}
	}
	
}
