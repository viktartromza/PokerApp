package com.tms.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Aspect
@Component
public class LoggerAspect {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
  //  @Around("within(com.tms.*)")
//@Pointcut("execution(public * com.tms.*.*()))")
//public void f(){}

//@Pointcut("execution(public * com.tms.*.*(String)))")
//public void ff(){}


   // @Around("f()||ff()")
    @Around("@annotation(com.tms.annotation.GetTimeAnnotation)")
    public void getLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        LocalTime start = LocalTime.now();
        log.info("Time start...");
        joinPoint.proceed();
        LocalTime end = LocalTime.now();
        log.info("Time end...");
        log.info("Method worked"+"   "+(end.getNano()-start.getNano())/1000000 +"  milisec");
    }
/*
    @Before("within(com.tms.*)")
    public void getLogBefore(JoinPoint joinPoint){
        log.info("Method" + joinPoint.getSignature() + "started!");
    }

    @After("within(com.tms.*)")
    public void getLogAfter(){
        log.info("Method finished!");
    }

    @AfterReturning(value = "within(com.tms.*)",returning = "result")
    public void getLogAfterReturning(Object result){
        log.info("Log after returning!" + result);
    }

    @AfterThrowing(value = "within(com.tms.*)",throwing ="err")
    public void getLogAfterThrowing(Throwable err){
        log.warn("WE HAVE THROW" + err);
    }*/
}
