package com.bach.curso.springboot.app.aop.springboot_aop.services;

import org.springframework.stereotype.Service;

@Service
public class GrettingServiceImpl implements GrettingService {

    @Override
    public String sayHello(String person, String phrase) {
        String gretting = phrase + " " + person;
        System.out.println(gretting);   
        return gretting;
    }

    @Override
    public String sayHelloError(String person, String phrase) {
        throw new RuntimeException("error in service");
    }

}
