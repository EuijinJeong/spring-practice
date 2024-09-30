package com.ktdsuniversity.edu.hello_spring.vo;


/**
 * 게시글의 정보를 담고 정보를 전달하는 용도로 사용하는 클래스이다.
 */
public class BoardVo {

	/**
	 * 게시글의 아이디값.
	 */
	private int id;
	/**
	 * 게시글의 제목.
	 */
	private String subject;
	/**
	 * 게시글의 내용.
	 */
	private String content;
	/**
	 * 게시글 작성자의 이메일.
	 */
	private String email;
	/**
	 * 게시글 조회수.
	 */
	private int viewCnt;
	/**
	 * 게시글 등록 날짜.
	 */
	private String crtDt;
	/**
	 * 게시글 수정 날짜
	 */
	private String mdfyDt;
	/**
	 * 게시글 첨부파일 내용.
	 */
	private String fileName;
	/**
	 * 이건 무슨 변수인지 모르겠어요..
	 */
	private String originFileName;
	
	
	
	// getters and setters.
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
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getCrtDt() {
		return crtDt;
	}
	public void setCrtDt(String crtDt) {
		this.crtDt = crtDt;
	}
	public String getMdfyDt() {
		return mdfyDt;
	}
	public void setMdfyDt(String mdfyDt) {
		this.mdfyDt = mdfyDt;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOriginFileName() {
		return originFileName;
	}
	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}
}
