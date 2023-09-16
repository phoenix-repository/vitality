package com.phoenix.spring6.prefix;

import com.phoenix.spring6.di.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:bean*.xml");
//        Resource resource = context.getResource("phoenix.txt");
//        System.out.println(resource.getDescription());

        User user = context.getBean(User.class);
        System.out.println(user);
    }
}
