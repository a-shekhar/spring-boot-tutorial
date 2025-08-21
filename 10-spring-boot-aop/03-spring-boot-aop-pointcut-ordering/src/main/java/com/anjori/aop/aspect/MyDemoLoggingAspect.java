package com.anjori.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.anjori.aop.Account;

@Aspect
@Component
@Order(4) // This aspect will execute last
public class MyDemoLoggingAspect {

    @Before("com.anjori.aop.aspect.AOPExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("======> Executing @Before advice on addAccount() <======");
   
        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // display method arguments

        // get args
        Object[] args = joinPoint.getArgs();

        // loop through args
        for(Object arg : args) {
            System.out.println("Argument: " + arg);

            if(arg instanceof Account){
                // downcast and print Account specific stuff
                Account account = (Account) arg;
                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            }
        }

    }

    

}
