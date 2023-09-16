package com.phoenix;

import com.phoenix.bean.AnnotationApplicationContext;
import com.phoenix.bean.ApplicationContext;
import com.phoenix.service.UserService;

public class TestUser {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationApplicationContext("com.phoenix");
        UserService userService = (UserService)context.getBean(UserService.class);
        System.out.println(userService);
        userService.add();
    }
}
