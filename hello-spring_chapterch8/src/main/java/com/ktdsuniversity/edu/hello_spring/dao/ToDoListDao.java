package com.ktdsuniversity.edu.hello_spring.dao;


import com.ktdsuniversity.edu.hello_spring.vo.ToDoListWriteVO;

public interface ToDoListDao {
	
	/**
	 * 새로운 할 일 등록하는 역할을 수행해주는 메서드.
	 * @param toDoListWriteVO
	 * @return: 생성된 리스트의 개수.
	 */
	public int insertNewToDoList(ToDoListWriteVO toDoListWriteVO);
	
	
//	public List<ToDoVO> selectAllToDoList();
}
