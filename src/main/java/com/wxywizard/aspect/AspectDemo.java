package com.wxywizard.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@Aspect
@Component
public class AspectDemo {

    /**
     * 定义切点
     */
    @Pointcut("execution(public * com.wxywizard.controller.Controller.listGirl(..))")
    public void log(){}

    /**
     * 获取http请求参数
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        log.info("方法执行前执行");
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("url={}",request.getRequestURL());
        log.info("method={}",request.getMethod());
        log.info("ip={}",request.getRemoteAddr());
        log.info("class_method={}",joinPoint.getSignature().getDeclaringType()+"."+joinPoint.getSignature().getName());
        log.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){

        log.info("方法最后执行");
    }

    @Around("log()")
    public void doAround(){
        log.info("方法环绕");
    }

    @AfterThrowing("log()")
    public void doThrowing(){
        log.info("方法异常时执行");
    }

    @AfterReturning(returning = "obj",pointcut = "log()")
    public void doAfterReturning(Object obj){
        log.info("response={}",obj);
    }
}
