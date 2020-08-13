package com.boz.bdmin.project.sys.user.controller;

import com.boz.bdmin.common.JSONResult;
import com.boz.bdmin.project.sys.user.entity.SysUser;
import com.boz.bdmin.project.sys.user.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author boz
 * @date 2019/7/4
 */

@RestController
@RequestMapping("/user/login")
@Slf4j
public class LoginController {

    @Autowired
    SysUserService sysUserService;

    /**
     * 登录
     * @param username
     * @param password
     * @param rememberMe
     * @return
     */
    @PostMapping("/login")
    public JSONResult login(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("rememberMe") Boolean rememberMe){

        log.info("username="+username+",password:"+password,"rememberMe:"+rememberMe);

        UsernamePasswordToken token = new UsernamePasswordToken(username,password,rememberMe);

        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            return JSONResult.ok();
        }catch (AuthenticationException e){
            return JSONResult.errorMsg("用户名或者密码错误");
        }
    }


    @GetMapping("/user")
    public JSONResult getAllUser(){
        List<SysUser> list = sysUserService.list();
        return JSONResult.ok(list);
    }
}
