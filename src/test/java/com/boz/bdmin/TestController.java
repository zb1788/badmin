package com.boz.bdmin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.boz.bdmin.project.sys.user.entity.SysUser;
import com.boz.bdmin.project.sys.user.mapper.SysUserMapper;
import com.boz.bdmin.project.sys.user.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestController {


    @Autowired
    SysUserMapper sysUserMapper;


    @Autowired
    SysUserService sysUserService;


//    @Autowired
//    SysRoleService sysRoleService;

    @Test
    public void aa() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date("2009/2/1");
        calendar.setTime(date);
        System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));


        List list = new ArrayList();
        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse("2019-02-01");
        aCalendar.setTime(date1);
        int year = aCalendar.get(Calendar.YEAR);//年份
        int month = aCalendar.get(Calendar.MONTH) + 1;//月份
        int day = aCalendar.getActualMaximum(Calendar.DATE);
        for (int i = 1; i <= day; i++) {
            String aDate = String.valueOf(year)+"/"+month+"/"+i;
            System.out.println(aDate);
            list.add(aDate);
        }
        System.out.println(list);

    }

    @Test
    public void testStringUtils(){
        List<SysUser> sysUsers = sysUserMapper.selectList(null);
        sysUsers.forEach(System.out::println);

//
//        List<SysRole> list1 = sysRoleService.list();
//        list1.forEach(System.out::println);

//        List<SysUser> list = sysUserService.list();
//        list.forEach(System.out::println);

        QueryWrapper<SysUser> sysUserQueryWrapper = new QueryWrapper<>();
        sysUserQueryWrapper.gt("id",1);

        List<SysUser> list1 = sysUserService.list(sysUserQueryWrapper);
        list1.forEach(System.out::println);

    }


}
