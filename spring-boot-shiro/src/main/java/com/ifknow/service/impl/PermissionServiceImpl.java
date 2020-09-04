package com.ifknow.service.impl;

import com.ifknow.mapper.PermissionMapper;
import com.ifknow.pojo.Permission;
import com.ifknow.service.PermissionService;
import com.ifknow.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ifknow
 * @since 2020-09-04
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RolePermissionService rolePermissionService;

    @Override
    public List<Permission> getPermissionsByRoleId(int roleid) {
        List<Integer> permissionIds = rolePermissionService.getPermissionIdsByRoleId(roleid);
        List<Permission> permissions = new ArrayList<>();
        for (Integer permissionId : permissionIds) {
            Example example = new Example(Permission.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("id", permissionId);
            Permission permission = permissionMapper.selectOneByExample(example);
            permissions.add(permission);
        }
        return permissions;
    }
}
