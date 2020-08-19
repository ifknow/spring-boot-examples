package com.ifknow.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ifknow <br>
 * @Date: 2020/8/17  14:38 <br>
 * @Description: NO Description
 */
@RestController
public class UserController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
