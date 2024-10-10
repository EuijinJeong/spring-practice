package com.ktdsuniversity.edu.hello_spring.access.dao;

import com.ktdsuniversity.edu.hello_spring.access.vo.AccessLogVO;


public interface AccessLogDao {
	
	public String NAMESPACE = "com.ktdsuniversity.edu.hello_spring.access.dao.AccessLogDao";
	
	/**
	 * 
	 * @param accessLogVO
	 * @return
	 */
	public int insertNewAccessLog(AccessLogVO accessLogVO);
	
	/**
	 * 
	 * @param ip
	 * @return
	 */
	public int selectLoginFailCount(String ip);

}
