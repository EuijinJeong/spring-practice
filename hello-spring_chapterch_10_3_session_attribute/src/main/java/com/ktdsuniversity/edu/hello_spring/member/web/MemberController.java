package com.ktdsuniversity.edu.hello_spring.member.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ktdsuniversity.edu.hello_spring.member.service.MemberService;
import com.ktdsuniversity.edu.hello_spring.member.vo.LoginMemberVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.MemberVO;
import com.ktdsuniversity.edu.hello_spring.member.vo.WriteNewMemberVO;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping("/member/signup")
	public String signInNewMember() {
		return "member/membersignup";
	}

	@PostMapping("/member/signup")
	public String doSignInNewMember(@Valid WriteNewMemberVO writeNewMemberVO, BindingResult bindingResult,
			Model model) {

		// 먼저 유효성 검사부터 실행.
		// 스프링의 유효성 검사.
		if (bindingResult.hasErrors()) {
			model.addAttribute("WriteNewMemberVO", writeNewMemberVO);
			return "member/membersignup";
		}

		// 비밀번호 확인 유효성 검사.
		if (writeNewMemberVO.getEmail() != writeNewMemberVO.getConfirmPassword()) {
			bindingResult.rejectValue("confirmPassword", "error.writeNewMemberVO", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("WriteNewMemberVO", writeNewMemberVO);
			return "member/membersignup";
		}

		System.out.println("이메일" + writeNewMemberVO.getEmail());
		System.out.println("이름" + writeNewMemberVO.getName());
		System.out.println("비밀번호" + writeNewMemberVO.getPassword());

		boolean isCreatedNewMember = memberService.insertNewMember(writeNewMemberVO);

		if (isCreatedNewMember) {
			System.out.println("성공적으로 회원가입이 완료되었습니다.");
			return "redirect:/board/list";
		} else {
			throw new IllegalArgumentException("예기치 못한 이유로 회원가입이 거부되었습니다.");
		}
	}

	@GetMapping("/member/regist/available")
	public Map<String, Object> doCheckAvailableEmail(@RequestParam String email) {

		boolean isAvailableEmail = this.memberService.checkAvailableEmail(email);

		Map<String, Object> response = new HashMap<>();
		response.put("email", email);
		response.put("available", isAvailableEmail);

		return response;
	}

	@GetMapping("/member/login")
	public String getSignInPage() {
		return "member/memberlogin";
	}

	@PostMapping("/member/login")
	public String doLogin(@Valid LoginMemberVO loginMemberVO, BindingResult bindingResult
			, HttpSession session, Model model) {

		// 먼저 유효성 검사.
		if(bindingResult.hasErrors()) {
			model.addAttribute("loginMemberVO", loginMemberVO);
			
			return "member/memberlogin";
		}
		
		// 통과한다면.
		MemberVO memberVO = new MemberVO();
		try {
			memberVO = this.memberService.readMember(loginMemberVO);

			// 로그인 상태를 서버에 저장시킨다. (보통 언더바 붙여서 작성한다.) (세션저장)
			session.setAttribute("_LOGIN_USER_", memberVO);
		} catch (IllegalArgumentException e) {
			model.addAttribute("loginMemberVO", loginMemberVO);
			model.addAttribute("message", e.getMessage());
			
			return "member/memberlogin";
		}

		return "redirect:/board/list";
	}
}
