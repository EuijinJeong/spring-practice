package com.ktdsuniversity.edu.hello_spring.bbs.dao.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.context.annotation.Import;

import com.ktdsuniversity.edu.hello_spring.bbs.dao.BoardDao;
import com.ktdsuniversity.edu.hello_spring.bbs.vo.WriteBoardVO;

@MybatisTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(BoardDaoImpl.class)
public class BoardDaoTest {
	
	@Autowired
	private BoardDao boardDao;
	
	@Test
	public void insertNewBoard() {
		WriteBoardVO writeBoardVO = new WriteBoardVO();
		writeBoardVO.setSubject("제목입니다.");
		writeBoardVO.setEmail("이메일입니다.");
		writeBoardVO.setContent("내용입니다.");
		
		int count = this.boardDao.insertNewBoard(writeBoardVO);
		assertTrue(count == 1);
	}
	
}
