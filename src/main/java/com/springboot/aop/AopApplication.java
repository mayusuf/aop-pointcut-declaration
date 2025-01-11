package com.springboot.aop;

import com.springboot.aop.dao.AccountDAO;
import com.springboot.aop.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
        return runner -> {
//            demoTheBeforeAdvice(accountDAO, membershipDAO);
//            demoTheAfterReturnAdvice(accountDAO);
            demoTheAfterAdvice(accountDAO);
        };
    }

    private void demoTheAfterAdvice(AccountDAO accountDAO) {

        try {
            boolean tripWire = true;
            accountDAO.afterAdviceMethod(tripWire);
        }catch (Exception e){
            System.out.println("Main : " + e.getMessage());
        }

    }

    private void demoTheAfterReturnAdvice(AccountDAO accountDAO) {

        accountDAO.findAccounts().forEach(System.out::println);

    }

    private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {

        Account account = new Account();
        boolean vipFlag = false;
        accountDAO.addAccount(account, vipFlag);
        accountDAO.doWork();

        membershipDAO.addSillyMember();
        membershipDAO.goToSleep();
    }

}
