package com.yedam.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect		// aspect(aop)
@Component	// 빈등록
public class AfterAdvice {
	
	@AfterReturning(pointcut = "LogAdvice.allPointcut()", returning = "returning")
	public void afterLog(JoinPoint jp, Object returning) {
		
		System.out.println("[log after]");
		
		String name = jp.getSignature().getName();
		System.out.println(name + " : ");
		System.out.println("return : " + returning);
	}
	
}
