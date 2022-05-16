package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
//通知类必须配置成Spring管理的bean
@Component
//设置当前类为切面类类
@Aspect
public class MyAdvice {
    //设置切入点，要求配置在方法上方
    /*void的表示切入方法的返回值*/
    /*有参数括号里写参数*/
    /*通配符 * 任意*/
    /*.. 多个任意符*/
    /* * com.itheima.dao.BookDao.update() 返回值是任意类型*/
    /* * com.itheima..update() 任意update方法 */
    /* * com.itheima.dao.BookDao.*()) 匹配类中所有方法*/
    @Pointcut("execution(* com.itheima.dao.BookDao.update())")
    private void pt(){}

    //设置在切入点pt()的before前面运行当前操作（前置通知）
    /*设置在切入点pt()的after前面运行当前操作（前置通知）*/
/*    @After("pt()")
    public void method(){
        System.out.println(System.currentTimeMillis());
    }*/
    /*环绕通知*/
    @Around("pt()")
    public void method1(ProceedingJoinPoint point) throws Throwable {
        System.out.println("lll");
        point.proceed();        /*使用环绕定义必须用这行调用原方法*/
        System.out.println("aaa");
    }
    /*/*如果原始方法是有返回值的类型 必须加上返回值这行 并把该方法的void改成object*/
    /*return 100*/
/*    @Around("pt()")
    public Object method2(ProceedingJoinPoint point) throws Throwable {
        System.out.println("lll");
        Object proceed = point.proceed();*//*使用环绕定义必须用这行调用原方法*//*
        System.out.println("aaa");
        return proceed;
    }*/
}
