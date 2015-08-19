package com.vmware.talentboost.spring.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AuthLoggingAspect {
	private static Logger logger = Logger.getLogger(AuthLoggingAspect.class.toString());
	
	@AfterReturning("execution(public * com.vmware.talentboost.spring.*.*AccountManager.authenticate(..))")
	public void logMessage(JoinPoint joinPoint){
		String message = joinPoint.getArgs()[0].toString()
				+ " has logged in!";
		logger.info(message);
	}
}
