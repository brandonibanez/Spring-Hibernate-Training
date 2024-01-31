package com.brandoncode.aopdemo.dao;

import com.brandoncode.aopdemo.Account;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public interface AccountDAO {
    void addAccount();
    void addAccount(Account account);
    void addAccount(Account account, boolean vipFlag);
    boolean doWork();
    public String getName();
    public void setName(String name);
    public String getServiceCode();
    public void setServiceCode(String serviceCode);
    List<Account> findAccounts();
    List<Account> findAccounts(boolean tripWire);
}
