package com.ktdsuniversity.edu.hello_spring.bbs.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.hello_spring.bbs.dao.impl.BoardDaoImpl;
import com.ktdsuniversity.edu.hello_spring.bbs.service.BoardService;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardListVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardVO;

// Spring Application의 Bean을 생성해주는 Annotation
@SpringBootTest

// Test하고자 하는 클래스와 Test에 필요한 클래스들을 import한다.
// BoardServiceImpl와 BoardDaoImpl을 테스트를 한다고 명시하는거임.
// BoardServiceImpl.class: BoardServiceImpl를 테스트 하기 위해 임포트한다.
// BoardDaoImpl.class: BoardServiceImpl에 BoardDaoImpl을 Autowired하기 위해 임포트한다.
@Import( { BoardServiceImpl.class, BoardDaoImpl.class} )
public class BoardServiceImplTest {
	
	@Autowired
	private BoardService boardService;
	

	// 왜 Autowired를 사용안하고 MockBean을 쓰는지? 
	// -> 테스트할 때 실질적으로 데이터베이스에 영향을 주면 안되기 때문에.
	
	// MockBean: 가짜 인스턴스를 생성해주는 어노테이션
	/**
	 * JUnit5 테스트를 위해 BoardServiceImpl에 가짜 인스턴스를 DI시킨다.
	 */
	@MockBean
	private BoardDao boardDao;
	
	@Test
	public void testGetAllBoard() {
		
		// given - when - then 패턴이라고 부른다.
		
		// given step
		// 1. boardDao.selectBoardAllCount()가 반환시킬 값을 명시한다.
		BDDMockito.given(boardDao.selectBoardAllCount()).willReturn(3);
		
		// given step
		// 2. boardDao.selectAllBoard()가 반환시킬 값을 명시한다.
		List<BoardVO> mockList = new ArrayList<>();
		mockList.add(new BoardVO());
		mockList.add(new BoardVO());
		mockList.add(new BoardVO());
		BDDMockito.given(boardDao.selectAllBoard()).willReturn(mockList);
		
		// when step
		// 3. BoardServiceImpl의 getAllBoard()를 호출한다.
		BoardListVO boardListVO = boardService.getAllBoard();
		
		// then step
		// 4. given 데이터와 실행데이터(boardListVO)가 일치하는지 검사한다. 
		// 아래에 있는 코드가 실패하면 테스트가 실패한다.
		assertEquals(3, boardListVO.getBoardCnt());
		assertEquals(3, boardListVO.getAllBoard().size());
		
	}
}
