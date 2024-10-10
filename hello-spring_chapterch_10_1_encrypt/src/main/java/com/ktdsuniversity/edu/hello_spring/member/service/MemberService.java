package com.ktdsuniversity.edu.hello_spring.member.service;

import com.ktdsuniversity.edu.hello_spring.member.vo.LoginMemberVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.WriteNewMemberVO;

public interface MemberService {
	
	public boolean insertNewMember(WriteNewMemberVO writeNewMemberVO);
	
	public boolean checkAvailableEmail(String email);
	
	public MemberVO readMember(LoginMemberVO loginMemberVO);
}
