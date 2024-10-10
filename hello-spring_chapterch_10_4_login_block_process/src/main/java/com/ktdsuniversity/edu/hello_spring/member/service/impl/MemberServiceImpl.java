package com.ktdsuniversity.edu.hello_spring.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktdsuniversity.edu.hello_spring.access.dao.AccessLogDao;
import com.ktdsuniversity.edu.hello_spring.access.vo.AccessLogVO;
import com.ktdsuniversity.edu.hello_spring.common.beans.Sha;
import com.ktdsuniversity.edu.hello_spring.common.utils.RequestUtil;
import com.ktdsuniversity.edu.hello_spring.member.dao.MemberDao;
import com.ktdsuniversity.edu.hello_spring.member.service.MemberService;
import com.ktdsuniversity.edu.hello_spring.member.vo.LoginMemberVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.WriteNewMemberVO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private AccessLogDao accessLogDao;
	
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
		
		// 존재하지 않는 이메일로 여러번 시도를 할 경우 해당 아이피를 block을 시킨다.
		boolean isIpBlock = this.accessLogDao.selectLoginFailCount(loginMemberVO.getIp()) >= 5;
		
		if(isIpBlock) {
			throw new IllegalArgumentException("이메일 또는 비밀번호가 올바르지 않습니다.");
		}
		
		// 1. salt 조회
		String salt = this.memberDao.selectSalt(loginMemberVO.getEmail());
		if(salt == null) {
			AccessLogVO accessLogVO = new AccessLogVO();
			accessLogVO.setAccessType("LOGIN");
			accessLogVO.setAccessUrl(RequestUtil.getRequest().getRequestURI());
			accessLogVO.setAccessMethod(RequestUtil.getRequest().getMethod().toUpperCase());
			accessLogVO.setAccessIp(RequestUtil.getIp());
			
			this.accessLogDao.insertNewAccessLog(accessLogVO);
			
			throw new IllegalArgumentException("이메일 또는 비밀번호가 올바르지 않습니다.");
		}
		
		// 2. 사용자가 입력한 비밀번호를 salt를 이용해 암호화.
		String password = loginMemberVO.getPassword();
		password = this.sha.getEncrypt(password, salt);
		loginMemberVO.setPassword(password);
		
		// 3. 이메일과 암호화된 비밀번호로 데이터베이스에서 회원 정보 조회.
		MemberVO memberVO = this.memberDao.selectOneMember(loginMemberVO.getEmail());
		// 이메일은 있지만 해당 password가 틀린 경우.
		if(memberVO == null) {
			// login fail count를 1 증가시킨다.
			// latest login fail date를 현재 날짜로 갱신한다.
			// latest login ip를 요청자의 ip로 갱신한다.
			loginMemberVO.setIp(RequestUtil.getIp());
			this.memberDao.updateLoginFailState(loginMemberVO);
			
			throw new IllegalArgumentException("이메일 또는 비밀번호가 올바르지 않습니다.");
		}
		// login fail count가 5 이상 && 마지막 로그인 실패 시간이 한시간이 지나지 않았더라면, 
		// 정상적인 로그인 시도라고 하더라도 로그인을 실패시켜야 한다.
		// 여기까지 코드가 흘러온건 email도 맞고 password도 맞는 경우이다.
		boolean isBlockState = this.memberDao.selectLoginImpossibleCount(loginMemberVO.getEmail()) > 0;
		if(isBlockState) {
			throw new IllegalArgumentException("이메일 또는 비밀번호가 올바르지 않습니다.");
		}
		
		// login fail count가 5이상 && 마지막 로그인 실패 시간이 한시간이 지났다면,
		// 혹은 login fail count가 5미만일 경우,
		// 정상적인 로그인 시도일 경우 로그인 성공시킨다.
		// 이때 login fail count는 0으로 초기화시키고
		// latest login fail date는 null로 초기화
		// latest login ip는 요청자의 ip로 갱신
		// latest login success date는 현재 날짜로 갱신.
		loginMemberVO.setIp(RequestUtil.getIp());
		this.memberDao.updateSuccessState(loginMemberVO);
		
		AccessLogVO accessLogVO = new AccessLogVO();
		accessLogVO.setAccessType("LOGIN");
		accessLogVO.setAccessEmail(memberVO.getEmail());
		accessLogVO.setAccessUrl(RequestUtil.getRequest().getRequestURI());
		accessLogVO.setAccessMethod(RequestUtil.getRequest().getMethod().toUpperCase());
		accessLogVO.setAccessIp(RequestUtil.getIp());
		accessLogVO.setLoginSuccessYn("Y");
		
		this.accessLogDao.insertNewAccessLog(accessLogVO);
		
		return memberVO;
	}
	
	@Override
	public boolean deleteMember(String email) {
		int deleteCount = this.memberDao.deleteMe(email);
		return deleteCount > 0;
	}
}
