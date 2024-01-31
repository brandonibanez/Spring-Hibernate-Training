package com.brandoncode.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.brandoncode.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.brandoncode.aopdemo.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* com.brandoncode.aopdemo.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageWithoutGetterAndSetter() {}

}
