package com.boz.bdmin.project.test.controller;

import com.boz.bdmin.common.JSONResult;
import com.boz.bdmin.common.i18n.utils.LocalMessage;
import com.boz.bdmin.project.test.properties.domain.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private LocalMessage localMessage;


    @Autowired
    private Project project;


    @RequestMapping("/test")
    public JSONResult test(){

        String tmp = localMessage.getMessage("user.not.exists");
        logger.info(project.toString());
        return JSONResult.ok(tmp);
    }
}
