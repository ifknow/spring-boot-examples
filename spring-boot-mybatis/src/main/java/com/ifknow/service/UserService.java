package com.ifknow.service;

import com.ifknow.pojo.bo.UserInsertBO;
import com.ifknow.pojo.bo.UserUpdateBO;
import com.ifknow.pojo.model.User;

import java.util.List;

/**
 * @Author: ifknow <br>
 * @Date: 2020/8/19  16:00 <br>
 * @Description: NO Description
 */
public interface UserService {
    /**
     * 新增用户
     *
     * @param bo 用户信息
     * @return
     */
    int insert(UserInsertBO bo);

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return
     */
    int delete(String id);

    /**
     * 更新用户信息
     *
     * @param bo 用户信息
     * @return
     */
    int update(UserUpdateBO bo);

    /**
     * 查询用户列表
     *
     * @return
     */
    List<User> pageInfo();
}
