package com.ktdsuniversity.edu.hello_spring.bbs.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.BoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.ModifyBoardVO;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.WriteBoardVO;

@Repository
public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao {

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sessionTemplate) {
		super.setSqlSessionTemplate(sessionTemplate);
	}

	@Override
	public int selectBoardAllCount() {
		return this.getSqlSession()
				.selectOne("com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao.selectBoardAllCount");
	}

	@Override
	public List<BoardVO> selectAllBoard() {
		return this.getSqlSession().selectList("com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao.selectAllBoard");
	}

	/**
	 * 새로운 게시글을 추가해주는 쿼리문을 수행하는걸 호출하는 메소드
	 */
	@Override
	public int insertNewBoard(WriteBoardVO writeBoardVO) {
		return this.getSqlSession().insert("com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao.insertNewBoard",
				writeBoardVO);
	}

	@Override
	public int increaseViewCount(int id) {

		return this.getSqlSession().update("com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao.increaseViewCount",
				id);
	}

	@Override
	public BoardVO getOneBoard(int id) {

		return this.getSqlSession().selectOne("com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao.getOneBoard", id);
	}

	@Override
	public int updateOneBoard(ModifyBoardVO modifyBoardVO) {
		return getSqlSession().update("updateOneBoard", modifyBoardVO);
	}

	@Override
	public int deleteOneBoard(int id) {

		return this.getSqlSession().delete("com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao.deleteOneBoard", id);
	}
}
