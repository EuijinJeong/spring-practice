package com.ktdsuniversity.edu.hello_spring.dao;

import java.util.List;

import com.ktdsuniversity.edu.hello_spring.vo.BoardVo;
import com.ktdsuniversity.edu.hello_spring.vo.BoardWriteVo;

public interface BoardDao {
	
	/**
	 * 모든 게시글의 정보를 가져오는 메소드
	 * @return
	 */
	public List<BoardVo> getAllBoardList();
	
	/**
	 * 게시글의 개수 정보를 가져오는 메서드
	 * @return
	 */
	public int getBoardAllCount();
	
	/**
	 * 게시글을 등록하는 메서드
	 * @param boardWriteVo: 사용자가 입력한 게시글 정보를 담은 객체
	 * @return: 등록한 게시글의 개수 성공하면 1 실패하면 0을 반환한다.
	 */
	public int insertNewBoard(BoardWriteVo boardWriteVo);
	
	// 게시글을 조회하는 메서드
	public BoardVo serarchOneBoard(int id);
	
}
