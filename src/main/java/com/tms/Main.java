package com.tms;

import com.tms.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("com.tms")
@EnableAspectJAutoProxy
public class Main {

    public static void main(String[] args) {


        ApplicationContext cxt = new AnnotationConfigApplicationContext(Main.class);
        User user1 = (User) cxt.getBean("user");
        SomeLogic someLogic = (SomeLogic) cxt.getBean("someLogic");
        someLogic.firstTestMethod();
        someLogic.secondTestMethod("asdf");
        System.out.println(user1);
    }
}