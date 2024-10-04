package com.ktdsuniversity.edu.hello_spring.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.hello_spring.dao.BoardDao;
import com.ktdsuniversity.edu.hello_spring.vo.BoardVo;
import com.ktdsuniversity.edu.hello_spring.vo.BoardWriteVo;

@Repository
public class BoardDaoImpl extends SqlSessionDaoSupport implements BoardDao{
	
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public List<BoardVo> getAllBoardList() {
		
		return null;
	}
	
	@Override
	public int getBoardAllCount() {
		
		return 0;
	}
	
	@Override
	public int insertNewBoard(BoardWriteVo boardWriteVo) {
		
		// Mybatis를 사용해서 데이터베이스에 새로운 데이터를 삽입하는것을 실행하는 코드이다.
		this.getSqlSession().insert("insertNewBoard", boardWriteVo);
		return 0;
	}
	
	@Override
	public BoardVo serarchOneBoard(int id) {
		
		return null;
	}
}
