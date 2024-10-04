package com.ktdsuniversity.edu.hello_spring.dao;


import java.util.List;

import com.ktdsuniversity.edu.hello_spring.vo.ToDoListWriteVO;
import com.ktdsuniversity.edu.hello_spring.vo.ToDoVO;

public interface ToDoListDao {
	
	/**
	 * 새로운 할 일 등록하는 역할을 수행해주는 메서드.
	 * @param toDoListWriteVO
	 * @return: 생성된 리스트의 개수.
	 */
	public int insertNewToDoList(ToDoListWriteVO toDoListWriteVO);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public ToDoVO selectOneToDoList(int id);
	
	/**
	 * 
	 * @return
	 */
	public List<ToDoVO> selectAllToDoList();
	
	/**
	 * 
	 * @return
	 */
	public int selectCountToDoList();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public int updateIsFinished(int id);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public int deleteToDoList(int id);
}
