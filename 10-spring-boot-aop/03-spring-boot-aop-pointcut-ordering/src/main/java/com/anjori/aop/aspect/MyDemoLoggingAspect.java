package com.anjori.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(4) // This aspect will execute last
public class MyDemoLoggingAspect {

    @Before("com.anjori.aop.aspect.AOPExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("======> Executing @Before advice on addAccount() <======");
    }

}
