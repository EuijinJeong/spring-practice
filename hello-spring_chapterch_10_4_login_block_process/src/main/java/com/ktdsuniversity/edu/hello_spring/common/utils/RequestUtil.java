package com.ktdsuniversity.edu.hello_spring.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;

/**
 * 이 클래스는 사용자의 IP 정보를 핸들링하기 위해 작성되었음.
 * 
 * @author jeong-uijin
 */
public final class RequestUtil {
	
	/**
	 * 요청자의 요청 정보를 가져온다.
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		// RequestContextHolder는 스프링에서 요청 사항을 끄집어낼 수 있게 해준다.
		ServletRequestAttributes request = 
				(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		return request.getRequest();
	}
	
	/**
	 * 요청자의 IP를 가져오는 메서드
	 * @return: 요청자의 IP
	 */
	public static String getIp() {
		return getRequest().getRemoteAddr();
	}

}
