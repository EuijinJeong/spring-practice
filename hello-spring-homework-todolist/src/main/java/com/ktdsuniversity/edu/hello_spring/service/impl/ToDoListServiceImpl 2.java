package com.ktdsuniversity.edu.hello_spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.edu.hello_spring.dao.ToDoListDao;
import com.ktdsuniversity.edu.hello_spring.service.ToDoListService;
import com.ktdsuniversity.edu.hello_spring.vo.ToDoListWriteVO;

@Service
public class ToDoListServiceImpl implements ToDoListService {

	@Autowired
	private ToDoListDao toDoListDao;
	
	@Override
	public boolean insertNewToDoList(ToDoListWriteVO toDoListWriteVO) {
		int createdCount = toDoListDao.insertNewToDoList(toDoListWriteVO);
		
		return createdCount > 0;
	}
}
