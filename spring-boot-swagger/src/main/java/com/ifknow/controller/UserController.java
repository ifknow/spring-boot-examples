package com.ifknow.controller;

import com.ifknow.annotation.Api_Business;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: ifknow <br>
 * @Date: 2020/8/20  11:37 <br>
 * @Description: 用户信息Controller
 */
@Api(value = "用户管理 - 用户信息管理api", tags = "用户管理 - 用户信息管理api")
@RestController
@RequestMapping("/user")
@Api_Business
public class UserController {

    @ApiOperation(value = "新增用户信息", notes = "新增用户信息")
    @PostMapping("/insert")
    public String insert() {
        return "success";
    }

    @ApiOperation(value = "删除用户信息", notes = "删除用户信息")
    @DeleteMapping("/delete")
    public String delete(@RequestParam String id) {
        return "success";
    }

    @ApiOperation(value = "修改用户信息", notes = "修改用户信息")
    @PutMapping("/update")
    public String update() {
        return "success";
    }

    @ApiOperation(value = "查询用户信息", notes = "查询用户信息")
    @GetMapping("/pageInfo")
    public String pageInfo() {
        return "success";
    }
}

