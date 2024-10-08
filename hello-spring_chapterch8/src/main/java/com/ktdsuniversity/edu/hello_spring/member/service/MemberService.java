package com.ktdsuniversity.edu.hello_spring.member.service;

import com.ktdsuniversity.edu.hello_spring.member.vo.MemberLoginVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberSignUpVO;

public interface MemberService {
    /**
     *
     * @param memberSignUpVO
     * @return
     */
    public boolean addNewMember(MemberSignUpVO memberSignUpVO);

    /**
     * 중복된 이메일이 존재하는지의 여부를 검사하는 로직을 수행하는 메서드
     * @param email: 사용자가 검색한 이메일
     * @return: 이메일의 중복 여부
     */
    public boolean isDuplicatedEmail(String email);

    /**
     * 파라미터로 들어온 값을 통해서 사용자의 회원 정보를 데이터베이스와 일치하는지 검사하는
     * 역할을 수행하는 메서드이다.
     * @param memberLoginVO
     * @return
     */
    public boolean validationLoginMember(MemberLoginVO memberLoginVO);
}
