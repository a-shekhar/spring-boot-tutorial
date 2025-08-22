package com.anjori.aop.dao;

import java.util.List;

import com.anjori.aop.Account;

public interface AccountDAO {
    
    void addAccount(Account account, boolean vipFlag);

    boolean doWork();

    String getName();

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String code);

     List<Account> findAccounts();

    List<Account> findAccounts(boolean tripwire);
}
