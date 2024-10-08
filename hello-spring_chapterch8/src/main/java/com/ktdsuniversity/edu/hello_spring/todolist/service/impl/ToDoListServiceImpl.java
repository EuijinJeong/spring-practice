package com.ktdsuniversity.edu.hello_spring.todolist.service.impl;

import com.ktdsuniversity.edu.hello_spring.todolist.dao.ToDoListDao;
import com.ktdsuniversity.edu.hello_spring.todolist.service.ToDoListService;
import com.ktdsuniversity.edu.hello_spring.todolist.vo.ToDoListVO;
import com.ktdsuniversity.edu.hello_spring.todolist.vo.ToDoListWriteVO;
import com.ktdsuniversity.edu.hello_spring.todolist.vo.ToDoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ToDoListServiceImpl implements ToDoListService {

	@Autowired
	private ToDoListDao toDoListDao;
	
	@Override
	public boolean insertNewToDoList(ToDoListWriteVO toDoListWriteVO) {
		int createdCount = toDoListDao.insertNewToDoList(toDoListWriteVO);
		
		return createdCount > 0;
	}
	
	@Override
	public ToDoVO selectOneToDoList(int id) {
		ToDoVO toDoVO = toDoListDao.selectOneToDoList(id);
		
		if(toDoVO == null) {
			throw new IllegalArgumentException("데이터베이스에서 아이디를 가져오지 못했습니다." + toDoVO);
		}
		return toDoVO;
	}
	
	@Override
	public ToDoListVO selectAllToDoList() {
		ToDoListVO toDoListVO = new ToDoListVO();
		
		toDoListVO.setToDoListCount(toDoListDao.selectCountToDoList());
		toDoListVO.setToDoList(toDoListDao.selectAllToDoList());
		
		System.out.println("가져온 list객체: " + toDoListVO.getToDoListCount());
		return toDoListVO;
	}
	
	@Override
	public boolean updateIsFinished(int id) {
		
		int updatedCount = toDoListDao.updateIsFinished(id);
		
		if(updatedCount == 0) {
			System.out.println("업데이트된 쿼리문 없음.");
		}
		return updatedCount > 0;
	}
	
	@Override
	public boolean deleteToDoList(int id) {
		
		int deleteCount = toDoListDao.deleteToDoList(id);
		
		if(deleteCount == 0) {
			System.out.println("삭제된 쿼리문 없음.");
		}
		
		return deleteCount > 0;
	}
}
