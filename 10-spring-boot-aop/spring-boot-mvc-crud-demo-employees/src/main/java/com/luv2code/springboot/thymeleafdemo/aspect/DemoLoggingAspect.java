package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    private static final String PACKAGE_NAME = "com.luv2code.springboot.thymeleafdemo";

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* " + PACKAGE_NAME + ".controller.*.*(..))")
    private void forControllerPackage() {

    }

    @Pointcut("execution(* " + PACKAGE_NAME + ".service.*.*(..))")
    private void forServicePackage() {

    }

    @Pointcut("execution(* " + PACKAGE_NAME + ".dao.*.*(..))")
    private void forDaoPackage() {

    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {

    }

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        logger.info("===========>> in @Before: calling method: " + joinPoint.getSignature().toShortString());

        Object[] args = joinPoint.getArgs();

        for(Object temp : args) {
            logger.info("===========>> argument: " + temp);
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("===========>> in @AfterReturning: from method: " + joinPoint.getSignature().toShortString());

        logger.info("===========>> result: " + result);
    }

}
