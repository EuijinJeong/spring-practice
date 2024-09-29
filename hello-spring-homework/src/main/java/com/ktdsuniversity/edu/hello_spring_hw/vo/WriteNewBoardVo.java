package com.ktdsuniversity.edu.hello_spring_hw.vo;

public class WriteNewBoardVo {

	/**
	 * 게시글을 입력한 사용자의 아이디(이메일)
	 */
	private String email;
	
	/**
	 * 사용자가 입력한 게시글의 제목
	 */
	private String subject;
	
	/**
	 * 사용자가 입력한 게시글의 내용
	 */
	private String content;
	
	// getters and setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
