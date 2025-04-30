package com.bach.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Grettingaspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    // anotacion * indica que se ejecuta en cualquier metodo
    // si remplzamose service por * se ejecutara en cualquier clase del package
    // en cambio si utilizamos com.bach.curso.springboot.app.aop.springboot_aop..*./(..) se ejecutara en todos los package
    @Before("execution(String com.bach.curso.springboot.app.aop.springboot_aop.services.GrettingService.*(..))")
    private void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("before method: " + method + " args: " + args);
    }

    @After("execution(String com.bach.curso.springboot.app.aop.springboot_aop.services.GrettingService.*(..))")
    private void loggerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("after method: " + method + " args: " + args);
    }

    @AfterReturning("execution(String com.bach.curso.springboot.app.aop.springboot_aop.services.GrettingService.*(..))")
    private void loggerAfterReturning(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("after returning method: " + method + " args: " + args);
    }

    @AfterThrowing("execution(String com.bach.curso.springboot.app.aop.springboot_aop.services.GrettingService.*(..))")
    private void loggerAfterThowing(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("after throwing exception: " + method + " args: " + args);
    }

    @Around("execution(String com.bach.curso.springboot.app.aop.springboot_aop.services.*.*(..))")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable{
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;
        try {
            logger.info("method: " + method + " args con los parametros:  " + args);
            result = joinPoint.proceed();
            logger.info("method: " + method + " args retorna el resultado:  " + args);
            return result;
        } catch (Throwable e) {
            logger.error("error in call method: " + method + "()");
            throw e;
        }

        
    }
}
