package com.boz.bdmin.shiro;

import com.boz.bdmin.project.sys.user.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author boz
 * @date 2019/6/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ShiroWithUserReaMTest {


    @Test
    public void testShiro(){

        UserReamTest userReamTest = new UserReamTest();


        //1.构建SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(userReamTest);
        //2.主题提交认证信息
        SecurityUtils.setSecurityManager(defaultSecurityManager);

        Subject subject = SecurityUtils.getSubject();

        log.info(subject.toString());

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("boz","123456");
        subject.login(usernamePasswordToken);


        SysUser principal = (SysUser) subject.getPrincipal();
        Session session = subject.getSession();

        boolean authenticated = subject.isAuthenticated();


        subject.checkRole("admin");
        subject.checkPermission("user:edit");



        System.out.println(principal.toString());
        System.out.println(session);
        System.out.println(authenticated);
    }
}
