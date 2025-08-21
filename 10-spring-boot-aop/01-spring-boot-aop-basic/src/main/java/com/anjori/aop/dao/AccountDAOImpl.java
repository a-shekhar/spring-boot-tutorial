package com.anjori.aop.dao;

import org.springframework.stereotype.Repository;

import com.anjori.aop.Account;

@Repository 
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": Adding an account");
    }

}
