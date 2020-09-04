package com.ifknow.service.impl;

import com.ifknow.mapper.RoleMapper;
import com.ifknow.pojo.Role;
import com.ifknow.pojo.User;
import com.ifknow.service.RoleService;
import com.ifknow.service.UserRoleService;
import com.ifknow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ifknow
 * @since 2020-09-04
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserService userService;

    @Override
    public Role getRoleByUserName(String username) {
        User user = userService.getUserByUsername(username);
        Integer roleId = userRoleService.getRoleIdByUserId(user.getId());
        Role entity = new Role();
        entity.setId(roleId);
        Role role = roleMapper.selectByPrimaryKey(entity);
        return role;
    }
}
