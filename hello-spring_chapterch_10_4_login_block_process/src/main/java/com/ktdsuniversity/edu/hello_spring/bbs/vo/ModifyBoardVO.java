package com.ktdsuniversity.edu.hello_spring.bbs.vo;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ModifyBoardVO {
	
	private int id;
	
	@NotBlank(message = "제목은 필수 입력값입니다.")
	@Size(min = 5, message = "제목을 5자리 이상 입력해주세요.")
	private String subject;
	
	private String content;
	
	private String fileName;
	
	// 데이터베이스에 추가하기 위한 변수 생성.
	private String originFileName;
	
	// 사용자가 입력한 파일 정보
	private MultipartFile file;
	
	private String ip;
	
	// getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getIp() {
		return ip;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public MultipartFile getFile() {
		return file;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public String getOriginFileName() {
		return originFileName;
	}
	
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}
