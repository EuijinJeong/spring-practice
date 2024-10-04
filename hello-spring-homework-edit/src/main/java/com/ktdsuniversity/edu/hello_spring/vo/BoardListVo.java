package com.ktdsuniversity.edu.hello_spring.vo;

import java.util.List;

/**
 * 게시글의 목록 정보를 담고 정보를 전달하는 용도로 사용하는 클래스이다.
 */
public class BoardListVo {
	
	/**
	 * 게시글 조회수.
	 */
	private int viewCnt;
	/**
	 * 게시글 목록.
	 */
	private List<BoardVo> boardList;
	
	
	// getters and setters
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public List<BoardVo> getBoardList() {
		return boardList;
	}
	public void setBoardList(List<BoardVo> boardList) {
		this.boardList = boardList;
	}
}
