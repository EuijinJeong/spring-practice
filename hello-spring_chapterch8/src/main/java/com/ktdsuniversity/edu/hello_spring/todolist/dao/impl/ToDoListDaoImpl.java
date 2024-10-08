package com.ktdsuniversity.edu.hello_spring.todolist.dao.impl;

import java.util.List;

import com.ktdsuniversity.edu.hello_spring.todolist.dao.ToDoListDao;
import com.ktdsuniversity.edu.hello_spring.todolist.vo.ToDoListWriteVO;
import com.ktdsuniversity.edu.hello_spring.todolist.vo.ToDoVO;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ToDoListDaoImpl extends SqlSessionDaoSupport implements ToDoListDao {

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
