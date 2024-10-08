package com.ktdsuniversity.edu.hello_spring.member.dao;

import com.ktdsuniversity.edu.hello_spring.member.vo.MemberLoginVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberSignUpVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberVO;

public interface MemberDao {

    public String NAMESPACE = "com.ktdsuniversity.edu.hello_spring.member.dao.MemberDao";

    /**
     * 회원가입을 수행할 때 호출되는 메서드
     * @param memberSignUpVO: 사용자가 회원가입할 때 입력하는 값을 담은 객체
     * @return: insert된 컬럼의 개수
     */
    public int insertMember (MemberSignUpVO memberSignUpVO);

    /**
     * 중복된 이메일을 가지고 있는 회원의 리스트의 개수를 반환한다.
     * @param email: 사용자가 입력한 이메일 값
     * @return: 중복된 이메일의 개수
     */
    public int selectMemberEmail(String email);

    /**
     * 사용자가 입력한 로그인 입력 값을 바탕으로 멤버 정보를 select하는 쿼리를 수행하는 메서드.
     * @param memberLoginVO
     * @return
     */
    public MemberVO selectOneMember(MemberLoginVO memberLoginVO);

    public String selectSault(String email);

    /**
     * 사용자가 로그인에 실패하면 로그인 실패 로그를 업데이트 하는 쿼리를 호출하는 메서드.
     *
     * @param memberLoginVO: 로그인을 시도하는 사용자의 정보.
     */
    public int updateFailLoginStatus(MemberLoginVO memberLoginVO);

    public int updateSuccessLoginStatus(MemberLoginVO memberLoginVO);

    public int selectFailLoginCount(String email);
}
