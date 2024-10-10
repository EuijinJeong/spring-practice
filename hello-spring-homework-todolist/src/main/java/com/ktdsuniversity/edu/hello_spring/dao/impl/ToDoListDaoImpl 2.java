package com.ktdsuniversity.edu.hello_spring.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.hello_spring.dao.ToDoListDao;
import com.ktdsuniversity.edu.hello_spring.vo.ToDoListWriteVO;

/**
 * 
 */
@Repository
public class ToDoListDaoImpl extends SqlSessionDaoSupport implements ToDoListDao{

	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
		public int insertNewToDoList(ToDoListWriteVO toDoListWriteVO) {
		int createdCount = getSqlSession().insert("com.ktdsuniversity.edu.hello_spring.dao.ToDoListDao.insertToDoList", toDoListWriteVO);
			return createdCount;
		}
}
