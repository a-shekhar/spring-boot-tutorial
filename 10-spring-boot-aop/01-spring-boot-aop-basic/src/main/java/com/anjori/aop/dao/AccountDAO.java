package com.anjori.aop.dao;

import com.anjori.aop.Account;

public interface AccountDAO {
    
    void addAccount(Account account, boolean vipFlag);

    boolean doWork();
}
