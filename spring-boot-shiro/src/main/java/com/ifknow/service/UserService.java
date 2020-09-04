package com.ifknow.service;

import com.ifknow.pojo.User;

/**
 * @author ifknow
 * @since 2020-09-04
 */
public interface UserService {
    User getUserByUsername(String username);
}
