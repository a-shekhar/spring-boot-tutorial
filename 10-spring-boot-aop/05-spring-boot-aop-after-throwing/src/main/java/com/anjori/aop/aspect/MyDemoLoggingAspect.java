package com.anjori.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

    @AfterThrowing(pointcut = "execution(* com.anjori.aop.dao.AccountDAO.findAccounts(..))",
        throwing = "exe")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exe) {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=======> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("\n=======> The exception is: " + exe);
    }

    @After("execution(* com.anjori.aop.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=======> Executing @After (finally) on method: " + method);
    }




    // add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(pointcut= "execution(* com.anjori.aop.dao.AccountDAO.findAccounts(..))",
                    returning= "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=======> Executing @AfterReturning on method: " + method);
        // print out the results of the method call
        System.out.println("Result is: " + result);
        // let's post-process the data
        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);


        // print out the modified results
        System.out.println("Result is: " + result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account account : result) {
            String upperName = account.getName().toUpperCase();
            account.setName(upperName);
        }
    }

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
