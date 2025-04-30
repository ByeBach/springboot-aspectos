package com.bach.curso.springboot.app.aop.springboot_aop.services;

public interface GrettingService {
    String sayHello(String person, String phrase);
    String sayHelloError(String person, String phrase);

    
}