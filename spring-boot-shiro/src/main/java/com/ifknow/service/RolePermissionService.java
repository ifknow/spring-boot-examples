package com.ifknow.service;

import java.util.List;

/**
 * @author ifknow
 * @since 2020-09-04
 */
public interface RolePermissionService {

    /**
     * 根据角色id查询权限
     *
     * @param roleId
     * @return
     */
    List<Integer> getPermissionIdsByRoleId(int roleId);
}
