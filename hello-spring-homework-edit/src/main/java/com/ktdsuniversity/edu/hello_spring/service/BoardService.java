package com.ktdsuniversity.edu.hello_spring.service;

import java.util.List;

import com.ktdsuniversity.edu.hello_spring.vo.BoardVo;

public interface BoardService {
	
	// 모든 게시글의 정보를 가져오는 dao 메소드를 호출한다.
	public List<BoardVo> getAllBoardList();
	
	// 게시글을 등록하는 dao 메소드를 호출한다.
	public int insertNewBoard();
	
	// 게시글을 조회하는 dao 메서드를 호출한다.
	public BoardVo searchOneBoard(int id);
}
