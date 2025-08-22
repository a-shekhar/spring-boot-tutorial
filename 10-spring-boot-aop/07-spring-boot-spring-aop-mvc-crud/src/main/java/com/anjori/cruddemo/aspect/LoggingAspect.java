package com.anjori.cruddemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.anjori.cruddemo.controller.*.*(..))")
    public void forControllerPackage() {
        // Pointcut for all methods in the controller package
    }

    @Pointcut("execution(* com.anjori.cruddemo.service.*.*(..))")
    public void forServicePackage() {
        // Pointcut for all methods in the controller package
    }


    @Pointcut("execution(* com.anjori.cruddemo.dao.*.*(..))")
    public void forDaoPackage() {
        // Pointcut for all methods in the controller package
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    public void forApplicationFlow() {
        // Pointcut for all methods in the application flow
    }

    @Before("forApplicationFlow()")
    public void beforeAdvice(JoinPoint joinPoint) {
        // display the method we are calling
        String method = joinPoint.getSignature().toShortString();
        logger.info("======> in @Before: calling method: " + method);
    
        // display the arguments to the method
        Object[] args = joinPoint.getArgs();

        // display the arguments to the method
        for (Object arg : args) {
            logger.info("======> argument: " + arg);
        }
    
    }

    @AfterReturning(pointcut = "forApplicationFlow()", returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
        // display the method we are returning from
        String method = joinPoint.getSignature().toShortString();
        logger.info("======> in @AfterReturning: from method: " + method);
    
        // display the result of the method call
        logger.info("======> result: " + result);
    }
}
