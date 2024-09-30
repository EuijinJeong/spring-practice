package com.ktdsuniversity.edu.hello_spring.bbs.vo;

/**
 * 파라미터를 받아오기 위한 VO를 생성함.
 */
public class WriteBoardVO {
	// 사용자가 입력한 제목
	private String subject;
	
	// 사용자가 입력한 이메일 정보
	private String email;
	
	// 사용자가 입력한 내용 정보
	private String content;
	
	// getter and setter
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
