package com.ktdsuniversity.edu.hello_spring.service;

import com.ktdsuniversity.edu.hello_spring.vo.ToDoListVO;
import com.ktdsuniversity.edu.hello_spring.vo.ToDoListWriteVO;
import com.ktdsuniversity.edu.hello_spring.vo.ToDoVO;

public interface ToDoListService {

	public boolean insertNewToDoList(ToDoListWriteVO toDoListWriteVO);
	
	public ToDoVO selectOneToDoList(int id);
	
	public ToDoListVO selectAllToDoList();
	
	public boolean updateIsFinished(int id);
	
	public boolean deleteToDoList(int id);
}
