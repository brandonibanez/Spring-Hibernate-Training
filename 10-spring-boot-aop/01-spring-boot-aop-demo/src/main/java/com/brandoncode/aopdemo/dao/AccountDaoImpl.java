package com.brandoncode.aopdemo.dao;

import com.brandoncode.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDAO{

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

}
