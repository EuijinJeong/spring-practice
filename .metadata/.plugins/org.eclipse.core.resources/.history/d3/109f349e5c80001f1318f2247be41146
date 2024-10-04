package com.ktdsuniversity.edu.hello_spring.bbs.vo;

import org.springframework.web.multipart.MultipartFile;

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
	
	private String fileName;
	
	// 데이터베이스에 추가하기 위한 변수 생성.
	private String originFileName;
	
	// 사용자가 입력한 파일 정보
	private MultipartFile file;
	
	// getter and setter
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
		
		if(this.subject != null) {
			this.subject = this.subject.trim();
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
		
		if(this.email != null) {
			this.email = this.email.trim();
		}
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
		
		if(this.content != null) {
			this.content = this.content.trim();
		}
	}
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getOriginFileName() {
		return originFileName;
	}
	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
