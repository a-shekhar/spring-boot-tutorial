package com.anjori.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2) // This aspect will execute second
public class MyApiAnalyticsAspect {
    
    @Before("com.anjori.aop.aspect.AOPExpressions.forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("======> Performing API analytics <======");
    }
}
