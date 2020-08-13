package com.boz.bdmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,DruidDataSourceAutoConfigure.class})
@SpringBootApplication
@MapperScan({"com.boz.bdmin.project"})
public class BdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BdminApplication.class, args);
    }

}
