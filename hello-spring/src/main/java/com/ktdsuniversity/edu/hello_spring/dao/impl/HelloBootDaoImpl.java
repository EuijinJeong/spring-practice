package com.ktdsuniversity.edu.hello_spring.dao.impl;

import com.ktdsuniversity.edu.hello_spring.dao.HelloBootDao;
import org.springframework.stereotype.Repository;

/**
 * 데이터베이스와 통신을 수행하는 클래스 서비스가 관리하는 클래스. --> 서비스가 레퍼지토리에 대해서 트랜잭션을 수행한다.
 */
@Repository
public class HelloBootDaoImpl implements HelloBootDao {

	@Override
    public String getData() {
        // 인터페이스 메서드 구현
        return "Hello from DAO";
    }
}
