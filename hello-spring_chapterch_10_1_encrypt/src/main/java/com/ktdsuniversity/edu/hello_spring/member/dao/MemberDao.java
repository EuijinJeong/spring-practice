package com.ktdsuniversity.edu.hello_spring.member.dao;

import com.ktdsuniversity.edu.hello_spring.member.vo.LoginMemberVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.WriteNewMemberVO;

public interface MemberDao {
	
	// 인터페이스에서 변수를 정의하면 상수가 되기 때문에 static final이 생략이 가능하다.
	public String NAMESPACE = "com.ktdsuniversity.edu.hello_spring.member.dao.MemberDao";
	
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
	
	/**
	 * 로그인시 비밀번호 암호화를 위해 기존에 발급했던 salt값을 조회한다.
	 * @param email: 조회할 이메일.
	 * @return: 회원가입시 발급받은 salt값.
	 */
	public String selectSalt(String email);
	
	/**
	 * 이메일과 비밀번호로 회원 정보를 조회.
	 * @param loginMemberVO: 이메일과 비밀번호.
	 * @return: 이메일과 비밀번호가 일치하는 회원의 정보.
	 */
	public MemberVO selectMember(LoginMemberVO loginMemberVO);
}
