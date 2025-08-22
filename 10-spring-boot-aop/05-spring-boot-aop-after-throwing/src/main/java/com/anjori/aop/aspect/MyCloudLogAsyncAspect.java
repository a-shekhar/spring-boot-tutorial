package com.anjori.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1) // This aspect will execute first
public class MyCloudLogAsyncAspect {
    @Before("com.anjori.aop.aspect.AOPExpressions.forDaoPackageNoGetterSetter()")
    public void logToCloudAsync() {
        System.out.println("======> Logging to Cloud in Async fashion <======");
    }
}
