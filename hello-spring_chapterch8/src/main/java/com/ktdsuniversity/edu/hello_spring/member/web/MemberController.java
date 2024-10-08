package com.ktdsuniversity.edu.hello_spring.member.web;

import com.ktdsuniversity.edu.hello_spring.member.service.MemberService;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberLoginVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberSignUpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/member/signup")
    public String loadSignUpPage() {
        return "member/membersignup";
    }

    @PostMapping("/member/signup")
    public String signUpMember(MemberSignUpVO memberSignUpVO, Model model) {

        try {
            boolean isSuccess = this.memberService.addNewMember(memberSignUpVO);
            if(isSuccess) {
                return "member/memberlogin";
            }
            else {
                return "redirect:/member/signup";
            }
        } catch (IllegalArgumentException iae) {
            return "redirect:/member/signup";
        }
    }

    @GetMapping("/member/login")
    public String loadLoginPage() {
        return "member/memberlogin";
    }

    @PostMapping("/member/login")
    public String loginMember(MemberLoginVO memberLoginVO, Model model) {
        try {
            boolean isSuccessed = this.memberService.validationLoginMember(memberLoginVO);
            if(!isSuccessed) {
                System.out.println("로그인 실패.");
            }
        } catch ( IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return "member/memberlogin";
        }
        return "redirect:/todolist/list";
    }

}
