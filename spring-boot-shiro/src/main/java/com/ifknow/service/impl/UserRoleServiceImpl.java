package com.ifknow.service.impl;

import com.ifknow.mapper.UserRoleMapper;
import com.ifknow.pojo.UserRole;
import com.ifknow.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author ifknow
 * @since 2020-09-04
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public Integer getRoleIdByUserId(Integer userId) {
        Example example = new Example(UserRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("UserId", userId);
        UserRole userRole = userRoleMapper.selectOneByExample(example);
        return userRole.getRoleId();
    }
}
