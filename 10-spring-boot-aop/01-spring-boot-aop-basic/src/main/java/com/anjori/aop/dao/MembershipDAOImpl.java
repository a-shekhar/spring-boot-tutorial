package com.anjori.aop.dao;

import org.springframework.stereotype.Repository;

@Repository 
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public boolean addSillyMethod() {
        System.out.println(getClass() + ": Adding an account");
        return true;
    }

}
