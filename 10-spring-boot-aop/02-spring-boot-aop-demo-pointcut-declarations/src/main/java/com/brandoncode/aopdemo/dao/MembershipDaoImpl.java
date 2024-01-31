package com.brandoncode.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDaoImpl implements MembershipDAO{

    @Override
    public boolean addMemberBember() {
        System.out.println(getClass().getSimpleName() + ": Adding a member");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass().getSimpleName() + ": Going to sleep!");
    }
}
