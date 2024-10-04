package com.ktdsuniversity.edu.hello_spring.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.hello_spring.bbs.service.BoardService;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.ModifyBoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.WriteBoardVO;
import com.ktdsuniversity.edu.hello_spring.common.beans.FileHandler;
import com.ktdsuniversity.edu.hello_spring.common.vo.StoreResultVO;

@Service
public class BoardServiceImpl implements BoardService{

	// application.yml파일에서 app.multipart.base-dir 설정 값을 가지고 온다.
	// @Value는 Spring Bean에서만 사용이 가능하다.
	// Spring Bean: @Controller, @Service, @Repository에서 사용 가능.
	
	@Autowired
	private FileHandler fileHandler;
	
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
		// 파일 업로드 처리를 먼저 한다.
		MultipartFile file = writeBoardVO.getFile();

		StoreResultVO storeResultVO = fileHandler.storeFile(file);
		
		if(storeResultVO != null) {
			writeBoardVO.setFileName(storeResultVO.getObfuscatedFileName());
			writeBoardVO.setFileName(storeResultVO.getOriginFileName());
		}
		
		int createCount = boardDao.insertNewBoard(writeBoardVO);
		
		// 생성된 개수가 0보다 클 때 return (true) 아니면 false return
		return createCount > 0;
	}
	
	@Override
	public BoardVO getOneBoard(int id, boolean isIncrease) {
		BoardVO boardVO = new BoardVO();
	
		if(isIncrease) {
			// 파라미터로 받은 아이디에 해당하는 게시글의 조회수가 1 증가한다.
			int updateCount = boardDao.increaseViewCount(id);
			
			if(updateCount == 0) {
				// updateCount가 0이라는 건
				// 파라미터로 전달받은 id 값이 존재하지 않다라는 의미이다.
				// 이러한 경우, 사용자에게 잘못된 접근입니다 라는 예외를 보내줘야 한다.
				throw new IllegalArgumentException("잘못된 접근입니다.");
			} else {
				// 예외가 발생하지 않았다면, 게시글의 정보를 조회한다.
				
				boardVO = boardDao.getOneBoard(id);
				
				if(boardVO == null) {
					throw new IllegalArgumentException("잘못된 접근입니다.");
				}
			}
		}
		return boardVO;
	}
	
	@Override
	public boolean updateOneBoard(ModifyBoardVO modifyBoardVO) {
		
		MultipartFile file = modifyBoardVO.getFile();
		
		BoardVO tempBoardVO = boardDao.getOneBoard(modifyBoardVO.getId());
		String beforeUpdateFileName = tempBoardVO.getFileName();
		
		StoreResultVO storeResultVO = this.fileHandler.storeFile(file);
		if(storeResultVO != null) {
			modifyBoardVO.setFileName(storeResultVO.getObfuscatedFileName());
			modifyBoardVO.setOriginFileName(storeResultVO.getOriginFileName());
		}
		
		int updateCount = boardDao.updateOneBoard(modifyBoardVO);
		
		if(updateCount > 0) {
			this.fileHandler.deleteFile(beforeUpdateFileName);
		}
		
		return updateCount > 0;
	}
	
	@Override
	public boolean deleteOneBoard(int id) {
		BoardVO boardVO = this.boardDao.getOneBoard(id);
		
		int deleteCount = boardDao.deleteOneBoard(id);
		
		if(deleteCount > 0) {
			this.fileHandler.deleteFile(boardVO.getFileName());
		}
		
		return deleteCount > 0;
	}
}
