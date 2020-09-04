package com.ifknow.service;

import com.ifknow.pojo.Role;

/**
 * @author ifknow
 * @since 2020-09-04
 */
public interface RoleService {
    Role getRoleByUserName(String username);
}
