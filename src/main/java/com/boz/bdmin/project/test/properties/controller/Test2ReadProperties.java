package com.boz.bdmin.project.test.properties.controller;

import com.boz.bdmin.common.JSONResult;
import com.boz.bdmin.project.test.properties.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 批量获取properties的内容
 * 步骤：1. @PropertySource(value = {"classpath:author.properties"},encoding = "utf-8")
 *      2. 创建author对应的实体类
 *      3. @Autowired 注入当前类
 * @author boz
 * @date 2019/6/4
 */

@RestController
@RequestMapping("/test2Properties")
@PropertySource(value = {"classpath:author.properties"},encoding = "utf-8")
public class Test2ReadProperties {

    @Autowired
    private Author author;


    @RequestMapping("/getName")
    public JSONResult getName(){
        return JSONResult.ok(author.getName());
    }

}
