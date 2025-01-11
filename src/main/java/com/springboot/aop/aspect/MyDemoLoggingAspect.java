package com.springboot.aop.aspect;

import com.springboot.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @After("execution(* com.springboot.aop.dao.AccountDAO.afterAdviceMethod(..))")
    public void afterFinallyAdvice(JoinPoint joinPoint) {
        System.out.println("After Finally advice executed : " + joinPoint.getSignature().getName());
    }

    @AfterReturning(
            pointcut = "execution(* com.springboot.aop.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result) {

        System.out.println("After Returning Advice: Executing Method " + joinPoint.getSignature().toShortString());

        System.out.println("Modified Result: " + result);
        convertAccountNameToUpperCase(result);
    }

    private void convertAccountNameToUpperCase(List<Account> result) {
        for(Account ac:result){
            String name = ac.getName().toUpperCase();
            ac.setName(name);
        }
    }

    //    @Before("execution(public void updateAccount())")
//     @Before("execution(* add* (com.springboot.aop.Account, ..))")
//    @Before("execution(* com.springboot.aop.*.*.add* (..))")
//    @Pointcut("execution(* com.springboot.aop.dao.*.* (..))")
//    private void forDaoPackage() {}
//
//    @Before("forDaoPackage()")
//    public void beforeAddAccount() {
//        System.out.println("=======> Executing @Before Advice method");
//    }
//
//    @Before("forDaoPackage()")
//    public void performApiAnalytics() {
//        System.out.println("======> Performing @Before Advice method");
//    }
}
