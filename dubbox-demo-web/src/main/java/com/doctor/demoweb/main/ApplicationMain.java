package com.doctor.demoweb.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author sdcuike
 *
 * @time 2016年2月29日 下午2:38:14
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan({ "com.doctor.demo.controller", "com.doctor.demo.manager.impl" })
@ServletComponentScan({ "com.doctor.demo.filter" })
public class ApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }

}
