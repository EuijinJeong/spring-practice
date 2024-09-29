package com.ktdsuniversity.edu.hello_spring_hw.service;

import com.ktdsuniversity.edu.hello_spring_hw.vo.BoardListVo;
import com.ktdsuniversity.edu.hello_spring_hw.vo.WriteNewBoardVo;

/**
 * 게시판 관련해서 비즈니스 로직을 처리하는 파트
 */
public interface BoardService {
	
	/**
	 * 게시글의 목록을 가져옴.
	 * @return
	 */
	public BoardListVo getAllBoard();
	
	/**
	 * 새로운 게시글을 등록처리하는 비즈니스 로직을 수행하는 메서드.
	 * @param writeNewBoardVo: 사용자가 입력한 게시글의 정보
	 * @return: 정상적으로 등록이 되었는지 여부
	 */
	public boolean createNewBoard(WriteNewBoardVo writeNewBoardVo);
	
	
}
