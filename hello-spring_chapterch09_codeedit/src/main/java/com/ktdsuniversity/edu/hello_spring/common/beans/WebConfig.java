package com.ktdsuniversity.edu.hello_spring.common.beans;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// application.yml에서 설정하지 못하는 디테일한 설정을 위한 애노테이션.
@Configuration
// Spring WebMVC에 필요한 다양한 요소를 활성화 시키는 애노테이션.
//	- Spring Validator
//	- Spring Inteceptor
//	- ...
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	/**
	 * JSP View Resolver 설정.
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// 첫번째가 프리픽스 두번째가 서픽스.
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	/**
	 * Static Resource 설정.
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/js/**")
			.addResourceLocations("classpath:/static/js"); // http:/localhost:8080/js/jquery/jquery-3.1.3.min.js
		registry.addResourceHandler("/css/**") //http:localhost:8080/css/common/common.css
			.addResourceLocations("classpath:/static/css/"); 
	}
}
