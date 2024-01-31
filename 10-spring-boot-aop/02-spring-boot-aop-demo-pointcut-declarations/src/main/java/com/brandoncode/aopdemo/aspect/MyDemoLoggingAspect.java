package com.brandoncode.aopdemo.aspect;

import com.brandoncode.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

    private static final String PACKAGE_NAME =
            "com.brandoncode.aopdemo.aspect.AopExpressions.";

    @Around("execution(* com.brandoncode.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("\nExecuting @Around on method: " + proceedingJoinPoint.getSignature().toShortString());

        long begin = System.currentTimeMillis();

        Object result = null;

        try{
            result = proceedingJoinPoint.proceed();
        } catch(Exception e) {
            System.out.println(e.getMessage());

            throw e;
        }

        long end = System.currentTimeMillis();

        long duration = end - begin;

        System.out.println("\nDuration: " + duration / 1000.0 + " seconds");

        return result;
    }

    @After(PACKAGE_NAME + "forDaoPackageWithoutGetterAndSetter()")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        System.out.println("Executing @After (finally) on method: " + joinPoint.getSignature().toShortString());
    }

    @AfterThrowing(
            pointcut = "execution(* com.brandoncode.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {
        System.out.println("Executing @AfterThrowing on method: " + joinPoint.getSignature().toShortString());

        System.out.println("Exception: " + exc);
    }

    @AfterReturning(
            pointcut = "execution(* com.brandoncode.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        System.out.println("Method: " + joinPoint.getSignature().toShortString());

        System.out.println("Results: " + result);

        result.forEach(list -> list.setName(list.getName().toUpperCase()));

        System.out.println("Modified Results: " + result);

    }

    @Before(PACKAGE_NAME + "forDaoPackageWithoutGetterAndSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("@Before | Checking authorization of the user with any add method...");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method: signature " + methodSignature);

        Object[] args = joinPoint.getArgs();

        for(Object temp : args) {
            if(temp instanceof Account) {
                Account account = (Account) temp;
                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            }
        }
    }

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

//    @Before("execution(* add*())")
//    public void beforeAddAnyMethodAnyReturnAdvice() {
//        System.out.println("@Before | Checking authorization of the user with any add method...");
//    }

//    @Before("execution(* add*(com.brandoncode.aopdemo.Account))")
//    public void beforeAddAnyMethodAnyReturnWithAccountParamAdvice() {
//        System.out.println("@Before | Checking authorization of the user with any add method...");
//    }

//    @Before("execution(* add*(com.brandoncode.aopdemo.Account, ..))")
//    public void beforeAddAnyMethodAnyReturnWithAccountParamAdvice() {
//        System.out.println("@Before | Checking authorization of the user with any add method...");
//    }

//    @Before("execution(* add*(..))")
//    public void beforeAddAnyMethodAnyReturnWithAccountParamAdvice() {
//        System.out.println("@Before | Checking authorization of the user with any add method...");
//    }

}
