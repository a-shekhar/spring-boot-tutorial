package com.anjori.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where we add all of our related advices for logging

     // For example, we can add a method to log before the execution of a method in AccountDAO
    @Before("execution(* add*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("======> Executing @Before advice on addAccount() <======");
    }

    // // For example, we can add a method to log before the execution of a method in AccountDAO
    // @Before("execution(public void add*())")
    // public void beforeAddAccountAdvice() {
    //     System.out.println("======> Executing @Before advice on addAccount() <======");
    // }
}
