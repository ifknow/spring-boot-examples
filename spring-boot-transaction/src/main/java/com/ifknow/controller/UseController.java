package com.ifknow.controller;

import com.ifknow.aop.annotation.MyLog;
import com.ifknow.pojo.bo.UserInsertBO;
import com.ifknow.pojo.bo.UserUpdateBO;
import com.ifknow.pojo.model.User;
import com.ifknow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: ifknow <br>
 * @Date: 2020/8/19  15:58 <br>
 * @Description: NO Description
 */
@RestController
@RequestMapping("/user")
public class UseController {

    @Autowired
    private UserService userService;

    @PostMapping("/insert")
    @MyLog(title = "用户模块", action = "新增用户")
    public String insert(@RequestBody UserInsertBO bo) {
        int i = userService.insert(bo);
        if (i == 0) {
            return "error";
        }
        return "success";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam String id) {
        int i = userService.delete(id);
        if (i == 0) {
            return "error";
        }
        return "success";
    }

    @PutMapping("/update")
    public String update(@RequestBody UserUpdateBO bo) {
        int i = userService.update(bo);
        if (i == 0) {
            return "error";
        }
        return "success";
    }

    @GetMapping("/pageInfo")
    @MyLog(title = "用户模块", action = "查询用户")
    public List<User> pageInfo(){
        return userService.pageInfo();
    }
}
