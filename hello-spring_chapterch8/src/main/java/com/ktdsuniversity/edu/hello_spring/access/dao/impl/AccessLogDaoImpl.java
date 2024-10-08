package com.ktdsuniversity.edu.hello_spring.access.dao.impl;

import com.ktdsuniversity.edu.hello_spring.access.dao.AccessLogDao;
import com.ktdsuniversity.edu.hello_spring.access.vo.AccessLogVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberLoginVO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccessLogDaoImpl extends SqlSessionDaoSupport implements AccessLogDao {

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int selectFailAccessLoginCount(String ip) {
        return getSqlSession().selectOne(NAMESPACE + ".selectFailAccessLoginCount" , ip);
    }

    @Override
    public int insertAccessLog(AccessLogVO accessLogVO) {
        return getSqlSession().insert(NAMESPACE + ".insertAccessLog" , accessLogVO);
    }
}
