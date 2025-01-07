package com.springboot.aop.dao;

import com.springboot.aop.Account;

public interface AccountDAO {

    void addAccount(Account account, boolean vipFlag);
    boolean doWork();
}
