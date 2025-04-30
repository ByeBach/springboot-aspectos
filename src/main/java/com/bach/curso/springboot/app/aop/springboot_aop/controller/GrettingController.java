package com.bach.curso.springboot.app.aop.springboot_aop.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bach.curso.springboot.app.aop.springboot_aop.services.GrettingService;


@RestController
public class GrettingController {

    @Autowired
    private GrettingService grettingService;

    @GetMapping("/gretting")
    public ResponseEntity<?> gretting(){
        return ResponseEntity.ok(Collections.singletonMap("gretting", grettingService.sayHello("Bach", "Hello")));
    }

}
