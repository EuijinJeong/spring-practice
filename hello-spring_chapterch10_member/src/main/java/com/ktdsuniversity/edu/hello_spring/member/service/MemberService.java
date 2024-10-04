package com.ktdsuniversity.edu.hello_spring.member.service;

import com.ktdsuniversity.edu.hello_spring.member.vo.WriteNewMemberVO;

public interface MemberService {
	
	/**
	 * 
	 * @param writeNewMemberVO
	 * @return
	 */
	public boolean insertNewMember(WriteNewMemberVO writeNewMemberVO);
	
	public boolean checkAvailableEmail(String email);
}
