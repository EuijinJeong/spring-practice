package com.ktdsuniversity.edu.hello_spring.bbs.dao;

import java.util.List;

import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.ModifyBoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.WriteBoardVO;

public interface BoardDao {
	
	/**
	 * 등록된 게시글의 총 개수를 데이터베이스에서 가져와서 반환해주는 메서드.
	 * 
	 * @return: 등록된 모든 게시글의 갯수.
	 */
	public int selectBoardAllCount();
	
	/**
	 * 모든 게시글의 정보를 데이터베이스에서 가져와서 반환해주는 메서드.
	 * 
	 * @return : 등록된 모든 게시글의 리스트.
	 */
	public List<BoardVO> selectAllBoard();
	
	/**
	 * 새로운 게시글을 추가하는 메서드
	 * 
	 * @param writeBoardVO
	 * @return: 리턴타입을 int를 한 이유는 추가한 개수를 알기 위해서.
	 */
	public int insertNewBoard(WriteBoardVO writeBoardVO);
	
	/**
	 * 파라미터로 받은 게시글의 조회수를 1 증가시키는 메서드
	 * @param id
	 * @return
	 */
	public int increaseViewCount(int id);
	
	/**
	 * 파라미터로 전달받은 게시글 ID의 정보를 반환한다.
	 * @param id
	 * @return
	 */
	public BoardVO getOneBoard(int id);
	
	/**
	 * 
	 * @param modifyBoardVO
	 * @return
	 */
	public int updateOneBoard(ModifyBoardVO modifyBoardVO);
	
}
