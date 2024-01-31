package com.brandoncode.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLogAsyncAspect {

    private static final String PACKAGE_NAME =
            "com.brandoncode.aopdemo.aspect.AopExpressions.";

    @Before(PACKAGE_NAME + "forDaoPackageWithoutGetterAndSetter()")
    public void logToCloudAsync() {
        System.out.println("@Before | Logging to Cloud in async fashion");
    }
}
