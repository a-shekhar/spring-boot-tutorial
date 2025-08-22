package com.anjori.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpressions {
    @Pointcut("execution(* com.anjori.aop.dao.*.*(..))")
    public void forDaoPackage() {
        // this is a pointcut declaration
        // we can leave this empty, it just serves as a pointcut reference
    }

    @Pointcut("execution(* com.anjori.aop.dao.*.get*(..))")
    public void getter() {
        // pointcut for getter methods
    }

    @Pointcut("execution(* com.anjori.aop.dao.*.set*(..))")
    public void setter() {
        // pointcut for setter methods
    }

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {
        // pointcut for all methods in the dao package except getters and setters
    }
}
