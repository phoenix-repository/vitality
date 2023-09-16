package com.phoenix.service.impl;

import com.phoenix.anno.Bean;
import com.phoenix.anno.Di;
import com.phoenix.dao.UserDao;
import com.phoenix.service.UserService;

@Bean
public class UserServiceImpl  implements UserService {

    @Di
    private UserDao userDao;

    public void add() {
        System.out.println("service.......");
        //调用dao的方法
        userDao.add();
    }
}
