package com.anjori.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    
    @Pointcut("execution(* com.anjori.aop.dao.*.*(..))")
    private void forDaoPackage() {
        // this is a pointcut declaration
        // we can leave this empty, it just serves as a pointcut reference
    }

    @Pointcut("execution(* com.anjori.aop.dao.*.get*(..))")
    private void getter() {
        // pointcut for getter methods
    }

    @Pointcut("execution(* com.anjori.aop.dao.*.set*(..))")
    private void setter() {
        // pointcut for setter methods
    }

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {
        // pointcut for all methods in the dao package except getters and setters
    }

     // For example, we can add a method to log before the execution of a method in AccountDAO
    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("======> Executing @Before advice on addAccount() <======");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("======> Performing API analytics <======");
    }
}
