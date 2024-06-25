package org.tukorea.free.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {

	@Before("execution(* org.tukorea.free.service.UserServiceImpl.login(..))")
	public void beforeMethod(JoinPoint jp) {
		System.out.println(" [BeforeMethod] : 메소드 호출 전 ");
		Signature sig = jp.getSignature();
		System.out.println(" 메소드 이름: " + sig.getName());
		Object[] args = jp.getArgs();
		System.out.printf(" 인수 값: id = %s, password = %s\n", args[0], args[1]);
	}

	@After("execution(* org.tukorea.free.service.UserServiceImpl.login(..))")
	public void afterMethod() {
		System.out.println(" [AfterMethod] : 메소드 호출 후 ");
	}

	@AfterReturning(value = "execution(* org.tukorea.free.service.UserServiceImpl.login(..))", returning = "result")
	public void afterReturningMethod(JoinPoint jp, boolean result) {
		System.out.println(" [afterReturningMethod] : 메소드 호출 후 ");
		Signature sig = jp.getSignature();
		System.out.println(" 메소드 이름: " + sig.getName());
		if (result) {
			System.out.println(" 로그인 성공");
		} else {
			System.out.println(" 로그인 실패");
		}
	}

	@Around("execution(* org.tukorea.free.service.UserServiceImpl.login(..))")
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println(" [AroundMethod before] : 메소드 호출 전");
		Object result = pjp.proceed();
		System.out.println(" [AroundMethod after] : 메소드 호출 후");
		return result;
	}

	@AfterThrowing(value = "execution(* org.tukorea.free.service.UserServiceImpl.login(..))", throwing = "ex")
	public void afterThrowingMethod(Throwable ex) {
		System.out.println(" [AfterThrowingMethod] : 예외 발생 후");
		System.out.println(" exception value = " + ex.toString());
	}
}