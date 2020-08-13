package com.boz.bdmin.project.test.properties.controller;

import com.boz.bdmin.common.JSONResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 单个读取properties的内容
 * 步骤：1 @PropertySource(value = {"classpath:author.properties"},encoding = "utf-8")
 *      2 @Value("${author.name}")
 * 备注：如果要读取yml配置文件的属性值
 * 步骤：1 @Configuration注解是必须的，@Component同样适用
 *      2 @Value("${spring.redis.port:#{null}}")
 *      //:#{null}作用为在取不到对应配置值时，采用默认值null赋值
 * @author boz
 * @date 2019/6/4
 */

@RestController
@RequestMapping("/testProperties")
@PropertySource(value = {"classpath:author.properties"},encoding = "utf-8")
public class TestReadProperties {

    @Value("${author.name}")
    String name;

    @RequestMapping("/getName")
    public JSONResult getName(){
        return JSONResult.ok(name);
    }
}
