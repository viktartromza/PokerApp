package com.tms;

import com.tms.config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Main {

    public static void main(String[] args) {


        ApplicationContext cxt = new AnnotationConfigApplicationContext(SpringConfig.class);
       // User user1 = (User) cxt.getBean("user");
       // SomeLogic someLogic = (SomeLogic) cxt.getBean("someLogic");
       // someLogic.firstTestMethod();
        //someLogic.secondTestMethod("asdf");
       // System.out.println(user1);
    }
}