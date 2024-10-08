package com.ktdsuniversity.edu.hello_spring.todolist.vo;

import java.util.List;

/**
 * 
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
