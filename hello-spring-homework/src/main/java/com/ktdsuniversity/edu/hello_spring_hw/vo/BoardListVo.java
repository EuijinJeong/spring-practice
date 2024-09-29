package com.ktdsuniversity.edu.hello_spring_hw.vo;

import java.util.List;

/**
 * 게시글 목록에 대한 정보를 가지고 있는 데이터클래스이다.
 */
public class BoardListVo {

	/**
	 * 게시글 목록.
	 */
	private List<BoardVo> boardList;

	/**
	 * 게시글 등록 개수
	 */
	private int boardCnt;
	
	// getters and setters.
	public List<BoardVo> getBoardList() {
		return boardList;
	}
	public void setBoardList(List<BoardVo> boardList) {
		this.boardList = boardList;
	}
	public int getBoardCnt() {
		return boardCnt;
	}
	public void setBoardCnt(int boardCnt) {
		this.boardCnt = boardCnt;
	}

}
