package com.boz.bdmin.project.test.properties.config;

import com.boz.bdmin.project.test.properties.domain.Project;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author boz
 * @date 2019/6/5
 */

@Configuration
public class ProjectConfig {


    @Bean
    @ConfigurationProperties("badmin")
    public Project project(){
        return new Project();
    }
}
