package com.brandoncode.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDAO{

    @Override
    public void addAccount() {
        System.out.println(getClass().getSimpleName() + ": Adding an account");
    }

    @Override
    public void addAccounts() {
        System.out.println(getClass().getSimpleName() + ": Adding more accounts");
    }
}
