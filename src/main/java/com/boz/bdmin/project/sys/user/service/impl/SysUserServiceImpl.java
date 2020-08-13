package com.boz.bdmin.project.sys.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boz.bdmin.project.sys.user.entity.SysUser;
import com.boz.bdmin.project.sys.user.mapper.SysUserMapper;
import com.boz.bdmin.project.sys.user.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @author boz
 * @date 2019/7/4
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
}
