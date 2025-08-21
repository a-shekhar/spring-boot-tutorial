package com.anjori.aop.dao;

import org.springframework.stereotype.Repository;

@Repository 
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Adding an account");
    }

}
