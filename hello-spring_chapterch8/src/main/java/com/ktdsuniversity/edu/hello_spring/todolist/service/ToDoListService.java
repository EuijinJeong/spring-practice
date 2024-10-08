package com.ktdsuniversity.edu.hello_spring.todolist.service;

import com.ktdsuniversity.edu.hello_spring.todolist.vo.ToDoListVO;
import com.ktdsuniversity.edu.hello_spring.todolist.vo.ToDoListWriteVO;
import com.ktdsuniversity.edu.hello_spring.todolist.vo.ToDoVO;

public interface ToDoListService {

	public boolean insertNewToDoList(ToDoListWriteVO toDoListWriteVO);
	
	public ToDoVO selectOneToDoList(int id);
	
	public ToDoListVO selectAllToDoList();
	
	public boolean updateIsFinished(int id);
	
	public boolean deleteToDoList(int id);
}
