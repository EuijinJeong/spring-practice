package com.ktdsuniversity.edu.hello_spring.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.hello_spring.bbs.service.BoardService;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.WriteBoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDao boardDao;
	
	
	@Override
	public BoardListVO getAllBoard() {
		// 게시글 목록 화면에 데이터를 전송해주기 위해서 
		// 게시글의 건수와 게시글의 목록을 조회해 반환시킨다.
		
		// 1. 게시글의 건수를 조회한다.
		int boardCount = this.boardDao.selectBoardAllCount();
		
		// 2. 게시글의 목록을 조회한다.
		List<BoardVO> boardList = this.boardDao.selectAllBoard();
		
		// 3. BoardListVO를 만들어서 게시글의 건수와 목록을 할당한다.
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.setBoardCnt(boardCount);
		boardListVO.setBoardList(boardList);
		
		// 4. BoardListVO인스턴스를 반환한다.
		return boardListVO;
	};
	
	public boolean createNewBoard(WriteBoardVO writeBoardVO) {
		int createCount = boardDao.insertNewBoard(writeBoardVO);
		
		// 생성된 개수가 0보다 클 때 return (true) 아니면 false return
		return createCount > 0;
	}
	
	@Override
	public BoardVO getOneBoard(int id) {
		// 파라미터로 전달 받은 게시글의 조회수를 1 증가해야한다.
		// updateCount는 DB에 업데이트한 게시글의 수를 반환한다.
		
		int updateCount = boardDao.increaseViewCount(id);
		
		if(updateCount == 0) {
			// updateCount가 0이라는 건
			// 파라미터로 전달받은 id 값이 존재하지 않다라는 의미이다.
			// 이러한 경우, 사용자에게 잘못된 접근입니다 라는 예외를 보내줘야 한다.
			throw new IllegalArgumentException("잘못된 접근입니다.");
		}
		
		// 예외가 발생하지 않았다면, 게시글의 정보를 조회한다.
		BoardVO boardVO = new BoardVO();
		boardVO = boardDao.getOneBoard(id);
		
		return boardVO;
	}
}
