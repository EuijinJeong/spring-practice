package com.ktdsuniversity.edu.hello_spring.bbs.dao;

import java.util.List;

import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardVO;

/**
 * 이러한 함수들을 구현해라~ 하는 작업 명시서 같은
 */
public interface BoardDao {
	
	public int selectBoardAllCount();
	
	public List<BoardVO> selectAllBoard();
}
