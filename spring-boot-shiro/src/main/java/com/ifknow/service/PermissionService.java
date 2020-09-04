package com.ifknow.service;

import com.ifknow.pojo.Permission;

import java.util.List;

/**
 * @author ifknow
 * @since 2020-09-04
 */
public interface PermissionService{
    List<Permission> getPermissionsByRoleId(int roleid);
}
