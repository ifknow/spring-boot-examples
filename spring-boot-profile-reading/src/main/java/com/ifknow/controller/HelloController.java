package com.ifknow.controller;

import com.ifknow.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: GongShiYong <br>
 * @date: 2020/10/17  13:58 <br>
 * @description: NO Description
 */
@RestController
public class HelloController {

    @Autowired
    private ApplicationProperties applicationProperties;

    @GetMapping("/hello")
    public String hello() {
        return applicationProperties.getProperties().getUsername() + applicationProperties.getProperties().getEmail();
    }
}
