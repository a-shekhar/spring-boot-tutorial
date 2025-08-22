package com.anjori.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3) // This aspect will execute last
public class MyDemoLoggingAspect {

    @Around("execution(* com.anjori.aop.service.*.getFortune(..))") 
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // Print out method we are advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @Around on method: " + method);
        
        // Get begin timestamp
        long begin = System.currentTimeMillis();

        // Now, let's execute the method
        Object result = proceedingJoinPoint.proceed();

        // Get end timestamp
        long end = System.currentTimeMillis();

        // Compute duration and display it
        long duration = end - begin;

        System.out.println("\n=====>>> Duration: " + duration / 1000.0 + " seconds");
        
        return result;
    }
}
