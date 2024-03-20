package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.demo.security.CustomAccessDeniedHandler;
import com.example.demo.security.CustomLoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired 
	UserDetailsService detailService;
	
	// @Bean 메서드 or @Component 클래스 => Container에 빈 등록
	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
	@Bean
	public AuthenticationSuccessHandler successHandler() {
		return new CustomLoginSuccessHandler(); 
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.antMatchers("/", "/home").permitAll()
				.antMatchers("/empList").hasRole("ADMIN")
				.anyRequest().authenticated()
			)
			// 로그인페이지 커스터마이징
			
			// 람다식
//			.formLogin((form) -> form
//				.loginPage("/login")
//				.permitAll()
//			)
			.formLogin().loginPage("/login")
						.usernameParameter("userId")		// 로그인 ID 변경
						.loginProcessingUrl("/userLogin")	// 로그인페이지 URL 변경
						.successHandler(successHandler())
						.permitAll()
			.and()
			
			// 람다식
//			.logout((logout) -> logout.permitAll())
			.logout().logoutSuccessUrl("/customLogout") 	// URL부분 반드시 "/"로 시작
					 .permitAll()
			.and()
			
			// 람다식
//			.exceptionHandling( handler -> handler.accessDeniedHandler(accessDeniedHandler()));
			.exceptionHandling().accessDeniedHandler(accessDeniedHandler())
			.and()
//			.csrf().disable();	// 토큰 비활성화
			.userDetailsService(detailService);
		
		return http.build();
	}

//	@Bean
//	public UserDetailsService userDetailsService() {
//		// user 계정
//		UserDetails user =
//			 User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("1111")
//			//  .roles("ROLE_USER")
//				.roles("USER")
//				.build();
//		
//		// admin 계정
//		UserDetails admin =
//				User.withDefaultPasswordEncoder()
//				.username("admin")
//				.password("1111")
//			//	.roles("ROLE_ADMIN")
//				.roles("ADMIN")
//				.build();
//
//		return new InMemoryUserDetailsManager(user, admin);
//	}
}