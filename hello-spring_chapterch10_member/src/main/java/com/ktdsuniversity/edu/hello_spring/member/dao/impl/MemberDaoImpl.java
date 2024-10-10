package com.ktdsuniversity.edu.hello_spring.member.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ktdsuniversity.edu.hello_spring.member.dao.MemberDao;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.WriteNewMemberVO;

@Repository
public class MemberDaoImpl extends SqlSessionDaoSupport implements MemberDao{

	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public int inserstNewMember(WriteNewMemberVO writeNewMemberVO) {
		return getSqlSession().insert("com.ktdsuniversity.edu.hello_spring.member.dao.MemberDao.inserstNewMember", writeNewMemberVO);
	}
	
	@Override
	public int getEmailCount(String email) {
		int count = 0;
		
		count = getSqlSession().selectOne(email);
		return count;
	}
	
	@Override
	public MemberVO selectOneMember(String email) {
		return getSqlSession().selectOne("com.ktdsuniversity.edu.hello_spring.member.dao.MemberDao.selectOneMember", email);
	}
}
