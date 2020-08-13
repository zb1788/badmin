package com.boz.bdmin.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
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
public class ShiroTest {


    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();


    @Before
    public void addUser(){

        simpleAccountRealm.addAccount("boz","123456");
    }

    @Test
    public void testShiro(){
        //1.构建SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);
        //2.主题提交认证信息
        SecurityUtils.setSecurityManager(defaultSecurityManager);

        Subject currentUser = SecurityUtils.getSubject();

        System.out.println(currentUser);

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("boz","123456");
        currentUser.login(usernamePasswordToken);


        Object principal = currentUser.getPrincipal();
        Session session = currentUser.getSession();

        boolean authenticated = currentUser.isAuthenticated();

        System.out.println(principal);
        System.out.println(session);
        System.out.println(authenticated);
    }
}
