package com.springboot.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public boolean addSillyMember() {
        System.out.println(getClass().getName() + " Doing My DB work : Adding An Account !!");
        return false;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass().getName() + " I am going to sleep !!");
    }
}
