package com.stackroute.keepnote.aspect;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.stackroute.keepnote.controller.UserController;


/* Annotate this class with @Aspect and @Component */
@Aspect
@Component
public class LoggingAspect {

	/*
	 * Write loggers for each of the methods of controller, any particular method
	 * will have all the four aspectJ annotation
	 * (@Before, @After, @AfterReturning, @AfterThrowing).
	 */
private static final Logger logger=LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(* com.stackroute.keepnote.controller.*.*(..))")
	public void logBefore(JoinPoint joinPoint){
		logger.info("-----------befor--------------");
		logger.debug("method name"+joinPoint.getSignature().getName());
		//System.out.println("@Before:"+new Date());
	}
	
	@After("execution(* com.stackroute.keepnote.controller.*.*(..))")
	public void logAfter(JoinPoint joinPoint){
		//System.out.println("@After:"+new Date());
		logger.info("-----------befor--------------");
		logger.debug("method name"+joinPoint.getSignature().getName());
	}
	
	@AfterThrowing(pointcut = "execution(* com.stackroute.keepnote.controller.*.*(..))",
			throwing="exception")
	public void logAfterThrowing(Exception exception){
		//System.out.println("@AfterReturning:"+new Date());
		//System.out.println("Exception caught:"+ exception.getMessage());
	}
	
	@AfterReturning(pointcut = "execution(* com.stackroute.keepnote.controller.*.*(..)",
			returning="val")
	public void logAfterReturning(Object val){
		System.out.println("Method return value:"+ val);
		System.out.println("@AfterReturning:"+new Date());
	}
	
	}
