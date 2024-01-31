package com.brandoncode.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class ApiAnalyticsAspect {

    private static final String PACKAGE_NAME =
            "com.brandoncode.aopdemo.aspect.AopExpressions.";

    @Before(PACKAGE_NAME + "forDaoPackageWithoutGetterAndSetter()")
    public void performApiAnalytics() {
        System.out.println("@Before | Performing API analytics");
    }
}
