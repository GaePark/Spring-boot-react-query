package com.sist.web.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ReactQueryAOP {
	@Around("execution(* com.sist.web.controller.*Controller.*(..))")
	public Object around(ProceedingJoinPoint jp) throws Throwable
	{
		long start=System.currentTimeMillis();
		Object obj=jp.proceed();
		
		long end=System.currentTimeMillis();
		System.out.println("클라이언트 호출 메소드"+jp.getSignature().getName());
		System.out.println("걸린 시간:"+(end-start));
		return obj;
	}
}
