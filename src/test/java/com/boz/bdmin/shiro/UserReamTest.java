package com.boz.bdmin.shiro;

import com.boz.bdmin.project.sys.user.entity.SysUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author boz
 * @date 2019/6/25
 */
public class UserReamTest extends AuthorizingRealm {

    /**
     * 授权管理
     * 添加角色和权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //模拟获取当前用户
        List<String> ruleList = new ArrayList<>();
        List<String> permissionList = new ArrayList<>();
        ruleList.add("admin");
        ruleList.add("edit");

        permissionList.add("user:add");
        permissionList.add("user:edit");


        //添加角色和权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(ruleList);
        info.addStringPermissions(permissionList);
        return info;
    }


    /**
     * 登录认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        String username = upToken.getUsername();//获取用户名
        String password = ""; //获取密码
        //从数据库查询信息以及认证信息,如果认证通过就登录通过

        //模拟从数据库查询出来的结果
        SysUser sysUser = new SysUser();
        sysUser.setUserId(1);
        sysUser.setUserName("boz");
        sysUser.setPassword("123456");

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(sysUser, "123456", getName());
        return info;

    }
}
