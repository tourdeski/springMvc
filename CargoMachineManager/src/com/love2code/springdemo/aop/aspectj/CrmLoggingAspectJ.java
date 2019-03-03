package com.love2code.springdemo.aop.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CrmLoggingAspectJ {

    private Logger LOG = Logger.getLogger(getClass().getName());

    @Pointcut("execution( * com.love2code.springdemo.controller.*.*(..))")
    private void forController() {

    }

    @Pointcut("execution( * com.love2code.springdemo.service.*.*(..))")
    private void forService() {

    }

    @Pointcut("execution( * com.love2code.springdemo.dao.*.*(..))")
    private void forDao() {

    }

    @Pointcut("forController() || forService() || forDao()")
    private void forAppFlow() {

    }

    @Before("forAppFlow()")
    private void beforeAdvice(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().getName();

        LOG.info(String.format("=============> Call method %s", method));
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult")
    private void afterAdvice(JoinPoint joinPoint, Object theResult) {

        String method = joinPoint.getSignature().getName();

        LOG.info(String.format("=============> Call method %s", method));
    }

}
