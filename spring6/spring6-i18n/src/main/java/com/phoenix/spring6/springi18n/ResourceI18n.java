package com.phoenix.spring6.springi18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceI18n {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");

        Object[] objs = new Object[]{"phoenix",new Date().toString()};
        String value = context.getMessage("www.phoenix.com", objs, Locale.UK);
        System.out.println(value);
    }
}
