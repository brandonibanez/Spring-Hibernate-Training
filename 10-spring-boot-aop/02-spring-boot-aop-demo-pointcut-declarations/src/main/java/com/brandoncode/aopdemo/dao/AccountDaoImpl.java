package com.brandoncode.aopdemo.dao;

import com.brandoncode.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDAO{

    private String name;
    private String serviceCode;

    @Override
    public void addAccount() {
        System.out.println(getClass().getSimpleName() + ": Adding an account");
    }

    @Override
    public void addAccount(Account account) {
        System.out.println(getClass().getSimpleName() + ": Adding an account with Account Class");
    }

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass().getSimpleName() + ": Adding a VIP account with Account Class");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass().getSimpleName() + ": Do work");
        return false;
    }

    public String getName() {
        System.out.println(getClass().getSimpleName() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass().getSimpleName() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass().getSimpleName() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass().getSimpleName() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        if(tripWire) {
            throw new RuntimeException("No Cat food for you!!");
        }

        return List.of(
                new Account("Brandon", "Platinum"),
                new Account("Kurum Baram", "Silver"),
                new Account("Kyampoo", "Gold")
        );
    }
}
