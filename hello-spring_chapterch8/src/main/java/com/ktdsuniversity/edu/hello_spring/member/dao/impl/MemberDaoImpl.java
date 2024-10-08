package com.ktdsuniversity.edu.hello_spring.member.dao.impl;

import com.ktdsuniversity.edu.hello_spring.member.dao.MemberDao;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberLoginVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberSignUpVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberVO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberDaoImpl extends SqlSessionDaoSupport implements MemberDao {

    @Autowired
    @Override
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    @Override
    public int insertMember(MemberSignUpVO memberSignUpVO) {
        return getSqlSession().insert(NAMESPACE + ".insertMember", memberSignUpVO);
    }

    @Override
    public int selectMemberEmail(String email) {
        List<MemberVO> duplicatedMemberList = getSqlSession().selectList(NAMESPACE + ".selectMemberEmail", email);
        return duplicatedMemberList.size();
    }

    @Override
    public MemberVO selectOneMember(MemberLoginVO memberLoginVO) {
        return getSqlSession().selectOne(NAMESPACE + ".selectOneMember", memberLoginVO);
    }

    @Override
    public String selectSault(String email) {
        return getSqlSession().selectOne(NAMESPACE + ".selectSault", email);
    }

    @Override
    public int updateFailLoginStatus(MemberLoginVO memberLoginVO) {
        return getSqlSession().update(NAMESPACE + ".updateFailLoginStatus", memberLoginVO);
    }

    @Override
    public int updateSuccessLoginStatus(MemberLoginVO memberLoginVO) {
        return getSqlSession().update(NAMESPACE + ".updateSuccessLoginStatus", memberLoginVO);
    }

    @Override
    public int selectFailLoginCount(String email) {
        return getSqlSession().selectOne(NAMESPACE + ".selectFailLoginCount", email);
    }
}
