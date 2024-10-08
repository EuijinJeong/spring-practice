package com.ktdsuniversity.edu.hello_spring.todolist.dao;


import com.ktdsuniversity.edu.hello_spring.todolist.vo.ToDoListWriteVO;
import com.ktdsuniversity.edu.hello_spring.todolist.vo.ToDoVO;

import java.util.List;

public interface ToDoListDao {
	
	public int insertNewToDoList(ToDoListWriteVO toDoListWriteVO);
	
	public ToDoVO selectOneToDoList(int id);
	
	public List<ToDoVO> selectAllToDoList();
	
	public int selectCountToDoList();
	
	public int updateIsFinished(int id);
	
	public int deleteToDoList(int id);
}
