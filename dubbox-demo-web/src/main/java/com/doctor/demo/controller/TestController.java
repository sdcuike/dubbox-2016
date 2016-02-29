package com.doctor.demo.controller;

import java.time.LocalDateTime;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doctor.demo.common.dto.WelcomeDto;
import com.doctor.demo.common.dto.WelcomeResponseDto;
import com.doctor.demo.manager.impl.TestManagerImpl;

/**
 * @author sdcuike
 *
 * @time 2016年2月29日 下午3:31:12
 */

@RestController
@Configuration
public class TestController {

    @Resource(name = "testManagerImpl")
    private TestManagerImpl testManager;

    @RequestMapping(value = "/time", consumes = { "application/json; charset=UTF-8" })
    public LocalDateTime geDateTime() {
        return testManager.geLocalDateTime();
    }

    @RequestMapping(value = "/hello", consumes = { "application/json; charset=UTF-8" })
    public WelcomeResponseDto hello(@RequestBody WelcomeDto welcomDto) {
        return testManager.hello(welcomDto);
    }
}
