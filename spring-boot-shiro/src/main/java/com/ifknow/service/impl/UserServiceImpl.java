package com.ifknow.service.impl;

import com.ifknow.mapper.UserMapper;
import com.ifknow.pojo.User;
import com.ifknow.service.RoleService;
import com.ifknow.service.UserRoleService;
import com.ifknow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author ifknow
 * @since 2020-09-04
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;

    @Override
    public User getUserByUsername(String username) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        User user = userMapper.selectOneByExample(example);
        return user;
    }
}
