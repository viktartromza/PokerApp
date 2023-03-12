package com.tms;

import com.tms.annotation.GetTimeAnnotation;
import org.springframework.stereotype.Component;

@Component
public class SomeLogic {
    public void firstTestMethod(){
        System.out.println("Aspect done");
        //throw new OutOfMemoryError();
    }
@GetTimeAnnotation
    public  String secondTestMethod(String s){
        System.out.println("Bye");
        return "123";
    }
}
