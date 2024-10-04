package com.ktdsuniversity.edu.hello_spring.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.hello_spring.dao.ToDoListDao;
import com.ktdsuniversity.edu.hello_spring.vo.ToDoListWriteVO;
import com.ktdsuniversity.edu.hello_spring.vo.ToDoVO;

@Repository
public class ToDoListDaoImpl extends SqlSessionDaoSupport implements ToDoListDao{

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
		public int insertNewToDoList(ToDoListWriteVO toDoListWriteVO) {
		int createdCount = getSqlSession().insert("com.ktdsuniversity.edu.hello_spring.dao.ToDoListDao.insertNewToDoList", toDoListWriteVO);
			return createdCount;
		}
	
	@Override
	public ToDoVO selectOneToDoList(int id) {
		ToDoVO toDoVO = getSqlSession().selectOne("selectOneToDoList");
		return toDoVO;
	}
	
	@Override
		public List<ToDoVO> selectAllToDoList() {
			return getSqlSession().selectList("selectAllToDoList");
		}
	
	@Override
		public int selectCountToDoList() {
			return getSqlSession().selectOne("selectCountToDoList");
		}
	
	@Override
		public int updateIsFinished(int id) {
			return getSqlSession().update("updateIsFinished", id);
		}
	
	@Override
		public int deleteToDoList(int id) {
			return getSqlSession().delete("deleteToDoList", id);
		}
}
