package com.boz.bdmin.common.shiro.realm;

import com.boz.bdmin.project.sys.user.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自定义realm 处理登录 权限
 * @author boz
 * @date 2019/6/25
 */
public class UserRealm extends AuthorizingRealm {

    public static final Logger logger = LoggerFactory.getLogger(UserRealm.class);


//    @Autowired
//    SysRoleService sysRoleService;
//
//    @Autowired
//    SysPermissionService sysPermissionService;

    /**
     * 授权管理
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        Subject subject = SecurityUtils.getSubject();
        //获取登录用户信息
        SysUser user = (SysUser) subject.getPrincipal();

        //添加角色和权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        // 管理员拥有所有权限
        if (user.getUserId() == 1)
        {
            info.addRole("admin");
            info.addStringPermission("*:*:*");
        }
        else
        {
//            QueryWrapper<SysRole> queryWrapper = new QueryWrapper<SysRole>();
//            queryWrapper.eq("user_id",user.getUserId());
//            // 角色列表
//            List<SysRole> roleList = sysRoleService.list(queryWrapper);
//
//            for(SysRole sysRole:roleList){
//                //添加角色
//                info.addRole(sysRole.getRoleName());
//                // 权限列表
//                QueryWrapper<SysPermission> sysPermissionQueryWrapper = new QueryWrapper<>();
//                QueryWrapper<SysPermission> role_id = sysPermissionQueryWrapper.eq("role_id", sysRole.getId());
//                List<SysPermission> list = sysPermissionService.list(sysPermissionQueryWrapper);
//                for(SysPermission sysPermission:list){
//                    info.addStringPermission(sysPermission.getPermission());
//                }
//            }
        }
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
        return null;
    }
}
