package com.ktdsuniversity.edu.hello_spring.vo;

import java.util.List;

/**
 * 게시글의 수를 가져오기 위해 선언한 VO 클래스.
 */
public class ToDoListVO {
	/**
	 * ToDoList 개시글의 수.
	 */
	private int toDoListCount;
	/**
	 * ToDoList.
	 */
	private List<ToDoVO> toDoList;
	
	
	// getters and setters
	public int getToDoListCount() {
		return toDoListCount;
	}
	public List<ToDoVO> getToDoList() {
		return toDoList;
	}
	public void setToDoListCount(int toDoListCount) {
		this.toDoListCount = toDoListCount;
	}
	public void setToDoList(List<ToDoVO> toDoList) {
		this.toDoList = toDoList;
	}
}
