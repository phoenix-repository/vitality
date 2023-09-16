package com.phoenix.dao.impl;

import com.phoenix.anno.Bean;
import com.phoenix.dao.UserDao;
import org.springframework.stereotype.Repository;

@Bean
public class UserDaoImpl  implements UserDao {
    @Override
    public void add() {
        System.out.println("dao.......");
    }
}
