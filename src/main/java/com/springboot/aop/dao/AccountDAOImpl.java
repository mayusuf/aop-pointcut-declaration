package com.springboot.aop.dao;

import com.springboot.aop.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Account> findAccounts() {

        List<Account> accounts = new ArrayList<>();

        accounts.add(new Account("Yusuf","2345"));
        accounts.add(new Account("John","7890"));
        accounts.add(new Account("Yafi","9123"));

        return accounts;
    }

    public void afterAdviceMethod(boolean vipFlag)  {

        if(vipFlag){
            throw new RuntimeException("Simulated Exception");
        }

    }
}
