package com.ktdsuniversity.edu.hello_spring.access.dao;

import com.ktdsuniversity.edu.hello_spring.access.vo.AccessLogVO;

public interface AccessLogDao {

    public String NAMESPACE = "com.ktdsuniversity.edu.hello_spring.access.dao.AccessLogDao";

    public int selectFailAccessLoginCount(String ip);

    /**
     *
     * @param accessLogVO
     * @return
     */
    public int insertAccessLog(AccessLogVO accessLogVO);
}
