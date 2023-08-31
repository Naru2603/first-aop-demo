package com.infy.aspects;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalcLoggingAspects {

	@Pointcut("execution (* com.infy.service.Calculator.Addition(..))")
	public void myPointCut() {
	}

	@Before("myPointCut()")
	public void logBeforeAddition(JoinPoint joinPoint) {
		System.out.println("log Before addition() is running!");
		System.out.println("Calculator.Addition : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	@AfterReturning("execution (* com.infy.service.Calculator.Addition(..))")
	public void logAfterReturning(JoinPoint joinPoint) {
		System.out.println("log After Returning addition() is running!");
		System.out.println("Calculator.Addition : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	@AfterThrowing("execution (* com.infy.service.Calculator.Addition(..))")
	public void logAfterThrowing(JoinPoint joinPoint) {
		System.out.println("log After Throwing addition() is running!");
		System.out.println("Calculator.Addition : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	@After("execution (* com.infy.service.Calculator.Addition(..))")
	public void logAfterAddition(JoinPoint joinPoint) {
		System.out.println("log After  addition() is running!");
		System.out.println("Calculator.Addition : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	@Around("execution (* com.infy.service.Calculator.sum(..))")
	public void logAroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("****LoggingAspect.logAroundMethod() - Before method call");
        
        long start = System.nanoTime();
        Integer result = (Integer) pjp.proceed();
        System.out.println("method returened value --->>> "+result);
        long end = System.nanoTime();
        String methodName = pjp.getSignature().getName();
        System.out.println("Execution of " + methodName + " took " + 
          TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");

        System.out.println("****LoggingAspect.logAroundMethod() - After method call");
	}
}
