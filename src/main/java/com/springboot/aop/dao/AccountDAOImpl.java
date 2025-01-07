package com.springboot.aop.dao;

import com.springboot.aop.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass().getName() + " Doing My DB work : Adding An Account !!");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass().getName() + " Do Work !!");
        return false;
    }
}
