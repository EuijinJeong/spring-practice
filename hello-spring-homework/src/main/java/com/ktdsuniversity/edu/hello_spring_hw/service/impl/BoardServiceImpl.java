package com.ktdsuniversity.edu.hello_spring_hw.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ktdsuniversity.edu.hello_spring_hw.dao.BoardDao;
import com.ktdsuniversity.edu.hello_spring_hw.service.BoardService;
import com.ktdsuniversity.edu.hello_spring_hw.vo.BoardListVo;
import com.ktdsuniversity.edu.hello_spring_hw.vo.BoardVo;
import com.ktdsuniversity.edu.hello_spring_hw.vo.WriteNewBoardVo;

public class BoardServiceImpl implements BoardService{
	
	
	/**
	 * Bean Context에 등록된 BoardDao를 가져와 주입시킨다.
	 * 그냥 new 쓰는 대신 Autowired라고 생각하셈.
	 */
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public BoardListVo getAllBoard() {
		
		BoardListVo boardListVo = new BoardListVo();
		
		// 1. 게시글 몇 개 작성되어있는지 개수를 조회한다.
		boardListVo.setBoardCnt(boardDao.searchBoardCount());
		
		// 2. 게시글의 목록을 조회한다.
		boardListVo.setBoardList(boardDao.searchAllBoard());
		
		return boardListVo;
	}
	
	@Override
	public boolean createNewBoard(WriteNewBoardVo writeNewBoardVo) {
		// 데이터베이스에 게시글을 등록하는 로직을 아래에 작성한다.
		// createCount는 db에 등록한 게시글의 수를 반환한다.
		
		int createCount = boardDao.createNewBoard(writeNewBoardVo);
		
		// 게시글이 생성된 경우 (0보다 크다) true를 반환한다.
		return createCount > 0;
	}
	
	@Override
	public void increaseViewCount(BoardVo boardVo) {
		
		
	}
	
	
}
