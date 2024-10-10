package com.ktdsuniversity.edu.hello_spring.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.edu.hello_spring.common.beans.Sha;
import com.ktdsuniversity.edu.hello_spring.member.dao.MemberDao;
import com.ktdsuniversity.edu.hello_spring.member.service.MemberService;
import com.ktdsuniversity.edu.hello_spring.member.vo.LoginMemberVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.WriteNewMemberVO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private Sha sha;
	
	@Override
	public boolean insertNewMember(WriteNewMemberVO writeNewMemberVO) {
		
		int emailCount = memberDao.getEmailCount(writeNewMemberVO.getEmail());
		
		if(emailCount > 0) {
			throw new RuntimeException("이미 사용중인 이메일입니다.");
		}
	
		// 1. Salt 발급
		String salt = sha.generateSalt();
		
		// 2. 사용자의 비밀번호 암호화.
		String password = writeNewMemberVO.getPassword();
		password = sha.getEncrypt(password, salt);
		writeNewMemberVO.setPassword(password);
		writeNewMemberVO.setSalt(salt);
		
		int createCount = memberDao.inserstNewMember(writeNewMemberVO);
		
		return createCount > 0;
	}
	
	@Override
	public boolean checkAvailableEmail(String email) {
		int emailCount = memberDao.getEmailCount(email);
		
		return false;
	}
	
	@Override
	public MemberVO readMember(LoginMemberVO loginMemberVO) {
		
		// 1. salt 조회
		String salt = this.memberDao.selectSalt(loginMemberVO.getEmail());
		if(salt == null) {
			throw new IllegalArgumentException("이메일 또는 비밀번호가 올바르지 않습니다.");
		}
		
		// 2. 사용자가 입력한 비밀번호를 salt를 이용해 암호화.
		String password = loginMemberVO.getPassword();
		password = this.sha.getEncrypt(password, salt);
		loginMemberVO.setPassword(password);
		
		// 3. 이메일과 암호화된 비밀번호로 데이터베이스에서 회원 정보 조회.
		MemberVO memberVO = this.memberDao.selectOneMember(loginMemberVO.getEmail());
		if(memberVO == null) {
			throw new IllegalArgumentException("이메일 또는 비밀번호가 올바르지 않습니다.");
		}
		return memberVO;
	}
}
