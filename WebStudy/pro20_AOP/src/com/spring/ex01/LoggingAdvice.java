package com.spring.ex01;

import static java.lang.System.out;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		out.println("[메서드 호출 전 : LoggingAdvice");
		out.println(invocation.getMethod() + " 메서드 호출 전");
		
		Object object = invocation.proceed();
		
		out.println("[메서드 호출 후 : loggingAdvice");
		out.println(invocation.getMethod() + " 메서드 호출 후");
		
		return object;
	}
}
