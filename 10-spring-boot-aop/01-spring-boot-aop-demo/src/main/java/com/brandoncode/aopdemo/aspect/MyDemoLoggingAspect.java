package com.brandoncode.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

//    @Before("execution(public void addAccount())")
//    public void beforeAddAcountAdvice() {
//        System.out.println("@Before | Checking authorization of the user with any addAccount method...");
//    }

//    @Before("execution(public void com.brandoncode.aopdemo.dao.AccountDAO.addAccount())")
//    public void beforeAddAccountDAOAcountAdvice() {
//        System.out.println("@Before | Checking authorization of the user inside AccountDAO...");
//    }

//    @Before("execution(public void add*())")
//    public void beforeAddAnyMethodAdvice() {
//        System.out.println("@Before | Checking authorization of the user with any add method...");
//    }

//    @Before("execution(void add*())")
//    public void beforeAddAnyVoidMethodAdvice() {
//        System.out.println("@Before | Checking authorization of the user with any add method...");
//    }

    @Before("execution(* add*())")
    public void beforeAddAnyMethodAnyReturnAdvice() {
        System.out.println("@Before | Checking authorization of the user with any add method...");
    }

}
