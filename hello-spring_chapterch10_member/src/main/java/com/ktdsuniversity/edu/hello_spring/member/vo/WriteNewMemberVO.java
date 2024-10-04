package com.ktdsuniversity.edu.hello_spring.member.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 사용자가 입력하는 회원가입 정보.
 */
public class WriteNewMemberVO {
	
	@NotBlank(message = "이메일은 필수 입력 값입니다.")
	private String email;
	
	@NotBlank(message = "이름은 필수 입력값입니다.")
	private String name;
	
	@NotBlank(message = "비밀번호는 필수 입력값입니다.")
	@Size(min = 10, message = "비밀번호는 최소 10자리 이상입니다.")
	private String password;
	
	@NotBlank(message = "비밀번호확인은 필수 입력값입니다.")
	@Size(min = 10, message = "비밀번호확인은 최소 10자리 이상입니다.")
	private String confirmPassword;
	
	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
