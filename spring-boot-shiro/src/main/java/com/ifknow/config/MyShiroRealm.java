package com.ifknow.config;

import com.ifknow.pojo.Permission;
import com.ifknow.pojo.Role;
import com.ifknow.pojo.User;
import com.ifknow.service.PermissionService;
import com.ifknow.service.RoleService;
import com.ifknow.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: ifknow <br>
 * @description: 自定义 realm
 */
public class MyShiroRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(ShiroConfiguration.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 这个可以用来获取在登录的时候提交的其他额外的参数信息
        // HttpServletRequest request = (HttpServletRequest) ((WebSubject) SecurityUtils.getSubject()).getServletRequest();
        // 当前登录信息
        String username = (String) principals.getPrimaryPrincipal();
        Set<String> roles = new HashSet<String>();
        // 查询当前用户
        Role role = roleService.getRoleByUserName(username);
        roles.add(role.getRoleName());
        // 添加角色
        authorizationInfo.setRoles(roles);
        Set<String> permissions = new HashSet<String>();
        // 根据角色id获取权限
        List<Permission> querypermissions = permissionService.getPermissionsByRoleId(role.getId());
        for (Permission permission : querypermissions) {
            permissions.add(permission.getPermissionName());
        }
        // 添加权限
        authorizationInfo.setStringPermissions(permissions);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
        String loginName = (String) authToken.getPrincipal();
        // 获取用户密码
        User user = userService.getUserByUsername(loginName);
        if (user == null) {
            // 没找到帐号
            throw new UnknownAccountException();
        }
        String password = new String((char[]) authToken.getCredentials());
        // MD5 加密密码与数据库密码比对
        String inpass = (new Md5Hash(password, user.getUsername())).toString();
        if (!user.getPassword().equals(inpass)) {
            throw new IncorrectCredentialsException();
        }
        // 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(loginName, user.getPassword(),
                ByteSource.Util.bytes(loginName), getName());
        return authenticationInfo;
    }
}
