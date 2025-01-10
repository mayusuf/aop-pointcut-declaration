package com.springboot.aop.dao;

import com.springboot.aop.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount(Account account, boolean vipFlag);
    boolean doWork();
    List<Account> findAccounts();
}
