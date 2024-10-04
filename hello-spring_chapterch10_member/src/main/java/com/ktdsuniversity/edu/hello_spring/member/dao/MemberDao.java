package com.ktdsuniversity.edu.hello_spring.member.dao;

import com.ktdsuniversity.edu.hello_spring.member.vo.MemberVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.WriteNewMemberVO;

public interface MemberDao {
	/**
	 * 데이터베이스에 새로운 멤버를 추가하는 메서드.
	 * @param writeNewMemberVO
	 * @return
	 */
	public int inserstNewMember(WriteNewMemberVO writeNewMemberVO);
	
	/**
	 * 이메일값을 통해서 해당 이메일이 가지고 있는 개수를 가져온다.
	 * @param email
	 * @return
	 */
	public int getEmailCount(String email);
	
	/**
	 * 아이디값을 통해서 하나의 멤버를 조회하는 메서드.
	 * 
	 * @param email
	 * @return
	 */
	public MemberVO selectOneMember(String email);
}
