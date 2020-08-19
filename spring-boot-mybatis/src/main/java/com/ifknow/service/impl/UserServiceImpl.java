package com.ifknow.service.impl;

import com.ifknow.mapper.UserMapper;
import com.ifknow.pojo.bo.UserInsertBO;
import com.ifknow.pojo.bo.UserUpdateBO;
import com.ifknow.pojo.model.User;
import com.ifknow.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @Author: ifknow <br>
 * @Date: 2020/8/19  16:01 <br>
 * @Description: NO Description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insert(UserInsertBO bo) {
        User user = new User();
        BeanUtils.copyProperties(bo, user);
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        return userMapper.insertSelective(user);
    }

    @Override
    public int delete(String id) {
        User user = new User();
        user.setId(id);
        return userMapper.deleteByPrimaryKey(user);
    }

    @Override
    public int update(UserUpdateBO bo) {
        User user = new User();
        BeanUtils.copyProperties(bo, user);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<User> pageInfo() {
        return userMapper.selectAll();
    }
}
