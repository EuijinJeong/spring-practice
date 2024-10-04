package com.ktdsuniversity.edu.hello_spring.dao;


import java.util.List;

import com.ktdsuniversity.edu.hello_spring.vo.ToDoListWriteVO;
import com.ktdsuniversity.edu.hello_spring.vo.ToDoVO;

public interface ToDoListDao {
	
	public int insertNewToDoList(ToDoListWriteVO toDoListWriteVO);
	
	public ToDoVO selectOneToDoList(int id);
	
	public List<ToDoVO> selectAllToDoList();
	
	public int selectCountToDoList();
	
	public int updateIsFinished(int id);
	
	public int deleteToDoList(int id);
}
