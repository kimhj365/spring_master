package com.example.demo.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler  {

	// 로그인 성공 후에 해야 할 후속작업
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		
		log.info("Login Success");
		List<String> roleNames = new ArrayList<>();
		
		// 로그인한 사용자 Role 정보
		// Collection<Authority> 타입 => List<String> 타입으로 변환
		auth.getAuthorities().forEach(authority -> { roleNames.add(authority.getAuthority()); });
		log.info("roleNames : " + roleNames);
		
		// 사용자 권한 체크
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/empList");
		}
		else {
			response.sendRedirect("/hello");
		}
	}

}
