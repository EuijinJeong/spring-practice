package com.ktdsuniversity.edu.hello_spring.vo;

/**
 * ToDoVO 객체이다.
 */
public class ToDoVO {
	/**
	 * 할 일 아이디 값.
	 */
	private String id;
	/**
	 * 일정 완료 여부.
	 */
	private int isFinished;
	/**
	 * 할 일 제목.
	 */
	private String subject;
	/**
	 * 마감 기한
	 */
	private String deadLine;
	
	// getters and setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getIsFinished() {
		return isFinished;
	}
	public void setIsFinished(int isFinished) {
		this.isFinished = isFinished;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}
}
