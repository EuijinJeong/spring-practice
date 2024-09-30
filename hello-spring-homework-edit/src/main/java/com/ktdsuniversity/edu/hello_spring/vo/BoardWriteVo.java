package com.ktdsuniversity.edu.hello_spring.vo;

public class BoardWriteVo {
	/**
	 * 사용자가 입력한 글의 제목
	 */
	private String subject;
	/**
	 * 사용자의 이메일
	 */
	private String email;
	/**
	 * 사용자가 작성한 게시글의 내용
	 */
	private String content;
	
	
	// getter and setters
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
