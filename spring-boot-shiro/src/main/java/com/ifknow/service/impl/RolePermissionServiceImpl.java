package com.ifknow.service.impl;

import com.ifknow.mapper.RolePermissionMapper;
import com.ifknow.pojo.RolePermission;
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
public class RolePermissionServiceImpl implements RolePermissionService {
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public List<Integer> getPermissionIdsByRoleId(int roleId) {
        Example example = new Example(RolePermission.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleId", roleId);
        List<RolePermission> rolePermissions = rolePermissionMapper.selectByExample(example);
        List<Integer> permissionIds = new ArrayList<>();
        for (RolePermission rolePermission : rolePermissions) {
            Integer permissionId = rolePermission.getId();
            permissionIds.add(permissionId);
        }
        return permissionIds;
    }
}
