package com.marolix.set7.springbootdemo.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private final Log logger = LogFactory.getLog(LoggingAspect.class);

//	@Around("execution(* com.marolix..*(..))")
//	public void printMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
//
//		String method = joinPoint.getSignature().getName();
//		logger.info(method + "   calling");
////		Object a = joinPoint.proceed();
////		logger.info("result after invoking " + method + " is " + a);
//	}
    @Before("execution(* com.marolix..*.*(..))")
    public void logMethodCall(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("Calling method: " + method);
    }
}
