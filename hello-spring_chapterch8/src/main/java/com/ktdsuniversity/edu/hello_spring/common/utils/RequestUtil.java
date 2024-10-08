package com.ktdsuniversity.edu.hello_spring.common.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 이 클래스는 사용자의 IP 정보를 핸들링하기 위해 작성되었음.
 *
 * @author jeong-uijin
 */
public class RequestUtil {

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes.getRequest();
    }

    public static String getIp() {
        return getRequest().getRemoteAddr();
    }
}
