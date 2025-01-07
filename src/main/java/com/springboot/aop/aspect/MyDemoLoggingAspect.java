package com.springboot.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //    @Before("execution(public void updateAccount())")
//     @Before("execution(* add* (com.springboot.aop.Account, ..))")
//    @Before("execution(* com.springboot.aop.*.*.add* (..))")
    @Pointcut("execution(* com.springboot.aop.dao.*.* (..))")
    private void forDaoPackage() {}

    @Before("forDaoPackage()")
    public void beforeAddAccount() {
        System.out.println("=======> Executing @Before Advice method");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("======> Performing @Before Advice method");
    }
}
