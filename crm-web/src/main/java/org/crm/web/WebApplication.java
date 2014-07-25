package org.crm.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@Import(RepositoryRestMvcConfiguration.class)
public class WebApplication {
    public static void main(String args[]){
        SpringApplication.run(WebApplication.class, args);

    }
}