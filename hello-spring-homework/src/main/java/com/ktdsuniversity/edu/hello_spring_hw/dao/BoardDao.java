package com.ktdsuniversity.edu.hello_spring_hw.dao;

import java.util.List;

import com.ktdsuniversity.edu.hello_spring_hw.vo.BoardVo;
import com.ktdsuniversity.edu.hello_spring_hw.vo.WriteNewBoardVo;

public interface BoardDao {
	
	/**
	 * 게시글 목록 전체 조회하는 메서드
	 */
	public List<BoardVo> searchAllBoard();
	
	/**
	 * 게시글의 개수를 조회하는 메서드.
	 */
	
	public int searchBoardCount();
	
	/**
	 * 새로운 게시글을 db에 등록하는 역할을 수행하는 메서드
	 * @param writeNewBoardVo : 사용자가 입력한 게시글의 정보를 옮겨주는 객체
	 * @return : 성공적으로 데이터베이스에 등록이 완료되었는지 알기 위해
	 * 			 등록된 게시글의 개수를 반환한다.
	 */
	public int createNewBoard(WriteNewBoardVo writeNewBoardVo);
}
