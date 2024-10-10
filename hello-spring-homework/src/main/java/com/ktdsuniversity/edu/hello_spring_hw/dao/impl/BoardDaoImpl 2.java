package com.ktdsuniversity.edu.hello_spring_hw.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.hello_spring_hw.dao.BoardDao;
import com.ktdsuniversity.edu.hello_spring_hw.vo.BoardVo;
import com.ktdsuniversity.edu.hello_spring_hw.vo.WriteNewBoardVo;

@Repository
public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao{
	
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int searchBoardCount() {
		return getSqlSession().selectOne("searchBoardCount");
	}
	
	@Override
	public List<BoardVo> searchAllBoard() {
		
		return getSqlSession().selectList("searchAllBoard");
	}
	
	@Override
	public int createNewBoard(WriteNewBoardVo writeNewBoardVo) {
		
		// getSqlSession().insert()는 insert한 Row의 개수를 반환
		return getSqlSession().insert("createNewBoard", writeNewBoardVo);
	}
}
