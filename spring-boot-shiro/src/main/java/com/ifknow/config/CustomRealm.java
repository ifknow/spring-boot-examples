package com.ifknow.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ifknow <br>
 * @Date: 2020/8/27  11:03 <br>
 * @Description: NO Description
 */
public class CustomRealm extends AuthorizingRealm {

    private static final Set<String> tomRoleNameSet = new HashSet<>();
    private static final Set<String> tomPermissionNameSet = new HashSet<>();
    private static final Set<String> jerryRoleNameSet = new HashSet<>();
    private static final Set<String> jerryPermissionNameSet = new HashSet<>();

    static {
        tomRoleNameSet.add("admin");
        jerryRoleNameSet.add("user");
        tomPermissionNameSet.add("user:insert");
        tomPermissionNameSet.add("user:update");
        tomPermissionNameSet.add("user:delete");
        tomPermissionNameSet.add("user:query");
        jerryPermissionNameSet.add("user:query");
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        if (username == null) {
            throw new UnknownAccountException("用户名不能为空");
        }
        SimpleAuthenticationInfo info = null;
        if (username.equals("tom")) {
            return new SimpleAuthenticationInfo("tom", "123", CustomRealm.class.getName());
        } else if (username.equals("jerry")) {
            return new SimpleAuthenticationInfo("jerry", "123", CustomRealm.class.getName());
        } else {
            return null;
        }
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if (username.equals("tom")) {
            info.addRoles(tomRoleNameSet);
            info.addStringPermissions(jerryPermissionNameSet);
        } else if (username.equals("jerry")) {
            info.addRoles(jerryRoleNameSet);
            info.addStringPermissions(jerryPermissionNameSet);
        }
        return info;
    }
}
