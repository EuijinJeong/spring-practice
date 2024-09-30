package com.ktdsuniversity.edu.hello_spring.dao;

import java.util.List;

import com.ktdsuniversity.edu.hello_spring.vo.BoardVo;

public interface BoardDao {
	
	// 모든 게시글의 정보를 가져오는 메소드
	public List<BoardVo> getAllBoardList();
	
	// 게시글의 개수 정보를 가져오는 메서드
	public int getBoardCount();
	
	// 게시글을 등록하는 메서드
	public int insertNewBoard();
	
	// 게시글을 조회하는 메서드
	public int serarchOneBoard();
	
}
