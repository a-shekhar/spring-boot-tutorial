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
        //long begin = System.currentTimeMillis();
        long begin = System.nanoTime();

        // Now, let's execute the method
        Object result = null;
        try{
             result = proceedingJoinPoint.proceed();
        } catch(Exception e) {
            // Log the exception
            System.out.println(e.getMessage());

            // give user a custom message
            result = "Major accident! But no worries, your private AOP helicopter is on the way!";

        }

        // Get end timestamp
        //long end = System.currentTimeMillis();
        long end = System.nanoTime();

        // Compute duration and display it
        long duration = end - begin;

        System.out.println("\n=====>>> Duration: " + duration + " nano seconds");
        
        return result;
    }
}
