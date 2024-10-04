package com.ktdsuniversity.edu.hello_spring.vo;

/**
 * 사용자가 입력한 정보를 담은 VO 클래스이다.
 */
public class ToDoListWriteVO {
	private String subject;
	private String deadLine;
	
	
	// getters and setters
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
