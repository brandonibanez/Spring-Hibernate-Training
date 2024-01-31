package com.brandoncode.aopdemo.dao;

import com.brandoncode.aopdemo.Account;

public interface AccountDAO {
    void addAccount();
    void addAccount(Account account);
    void addAccount(Account account, boolean vipFlag);
    boolean doWork();
}
