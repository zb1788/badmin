package com.boz.bdmin.project.test.properties.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * properties对应的实体类
 * @author boz
 * @date 2019/6/4
 */

@Component
@ConfigurationProperties(prefix = "author")
public class Author {
    private String name;
    private  int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

