package com.ktdsuniversity.edu.hello_spring.member.service.impl;

import com.ktdsuniversity.edu.hello_spring.access.dao.AccessLogDao;
import com.ktdsuniversity.edu.hello_spring.access.vo.AccessLogVO;
import com.ktdsuniversity.edu.hello_spring.common.beans.Sha;
import com.ktdsuniversity.edu.hello_spring.common.utils.RequestUtil;
import com.ktdsuniversity.edu.hello_spring.member.dao.MemberDao;
import com.ktdsuniversity.edu.hello_spring.member.service.MemberService;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberLoginVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberSignUpVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private AccessLogDao accessLogDao;

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private Sha sha;

    @Override
    public boolean addNewMember(MemberSignUpVO memberSignUpVO) {

        boolean isDuplicated = this.isDuplicatedEmail(memberSignUpVO.getEmail());

        if(isDuplicated) {
            throw new RuntimeException("이미 사용중인 이메일입니다.");
        }

        String salt = sha.generateSalt();

        // 비밀번호 암호화 진행.
        String saltedPassword = sha.getEncrypt(memberSignUpVO.getPassword(), salt);
        memberSignUpVO.setPassword(saltedPassword);
        memberSignUpVO.setSalt(salt);

        int insertedMemberCount = this.memberDao.insertMember(memberSignUpVO);

        if(insertedMemberCount == 0) {
            throw new IllegalArgumentException("시스템 오류로 회원가입이 거절되었습니다.");
        }

        return insertedMemberCount > 0;
    }

    @Override
    public boolean isDuplicatedEmail(String email) {
        int duplicatedEmailCount = this.memberDao.selectMemberEmail(email);
        return duplicatedEmailCount > 0;
    }

    @Override
    public boolean validationLoginMember(MemberLoginVO memberLoginVO) {
        // 로그인을 시도하는게 정상적인지를 먼저 검사.

        // 만약 지금 로그인을 시도하고 있는 사람이 로그인 할 조건이 안된다면
        boolean isFailedLogin = this.accessLogDao.selectFailAccessLoginCount(memberLoginVO.getIp()) >= 5;
        if(isFailedLogin) {
            throw new IllegalArgumentException("로그인에 실패하였습니다.");
        }

        String salt = this.memberDao.selectSault(memberLoginVO.getEmail());
        // 만약 salt 값이 없다면.
        if(salt == null) {
            AccessLogVO accessLogVO = new AccessLogVO();
            accessLogVO.setAccessType("LOGIN");
            accessLogVO.setAccessUrl(RequestUtil.getRequest().getRequestURI());
            accessLogVO.setAccessMethod(RequestUtil.getRequest().getMethod().toUpperCase());
            accessLogVO.setAccessIp(RequestUtil.getIp());

            this.accessLogDao.insertAccessLog(accessLogVO);

            throw new IllegalArgumentException("이메일 또는 비밀번호가 올바르지 않습니다.");
        }

        String password = memberLoginVO.getPassword();
        password = this.sha.getEncrypt(password, salt);
        memberLoginVO.setPassword(password);

        // 이 객체가 null이라는건데,
        MemberVO memberVO = this.memberDao.selectOneMember(memberLoginVO);

        // 회원이 입력한 이메일값이 틀린 경우
        if(memberVO == null) {
            // AccessLog에 회원가입 실패 정보를 업데이트 해야한다.
            memberVO.setLatestLoginIp(RequestUtil.getIp());
            this.memberDao.updateFailLoginStatus(memberLoginVO);
            throw new IllegalArgumentException("해당 정보에 해당하는 회원 정보가 존재하지 않습니다.");
        }

        boolean isBlockedLogin = this.memberDao.selectFailLoginCount(memberLoginVO.getEmail()) >= 5;
        if(isBlockedLogin) {
            throw new IllegalArgumentException("현재 로그인 할 수 없습니다.");
        }
        // 아이디는 일치하는데 비밀번호가 틀린 경우
        if(!memberLoginVO.getPassword().equals(memberVO.getPassword())) {
            int updateFailLoginStatusCount = this.memberDao.updateFailLoginStatus(memberLoginVO);
            if(updateFailLoginStatusCount == 0) {
                System.out.println("시스템상의 오류로 쿼리가 작동되지 않았습니다.");
            }
            throw new IllegalArgumentException("해당 정보에 해당하는 회원 정보가 존재하지 않습니다.");
        }

        // 이메일도 맞고 비밀번호도 맞아서 로그인에 성공할 경우.
        // 로그인 성공 정보 업데이트 해야함.

        int updateSuccessLoginStatusCount = this.memberDao.updateSuccessLoginStatus(memberLoginVO);
        if(updateSuccessLoginStatusCount == 0) {
            System.out.println("시스템상의 오류로 쿼리가 작동되지 않았습니다.");
        }
        return true;
    }
}
