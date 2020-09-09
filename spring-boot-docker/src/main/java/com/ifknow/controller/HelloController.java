package com.ifknow.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ifknow <br>
 * @date: 2020/9/8  10:32 <br>
 * @description: NO Description
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Docker!";
    }
}
