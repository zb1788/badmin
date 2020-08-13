package com.boz.bdmin.project.test.properties.controller;

import com.boz.bdmin.common.JSONResult;
import com.boz.bdmin.project.test.properties.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author boz
 * @date 2019/6/5
 */

@RestController
@RequestMapping("/test3")
public class Test3 {



    @Autowired
    private Project project;


    @RequestMapping("/test")
    public JSONResult test(){

        String msg = project.toString();
        return JSONResult.ok(msg);
    }
}
