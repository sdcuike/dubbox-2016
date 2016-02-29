package com.doctor.demo.manager.impl;

import java.time.LocalDateTime;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.doctor.demo.common.dto.WelcomeDto;
import com.doctor.demo.common.dto.WelcomeResponseDto;
import com.doctor.demo.service.HelloService;

/**
 * @author sdcuike
 *
 * @time 2016年2月29日 下午3:46:08
 */

@Repository("testManagerImpl")
public class TestManagerImpl {

    @Resource(name = "helloServiceClient")
    private HelloService helloService;

    public LocalDateTime geLocalDateTime() {
        return LocalDateTime.now();
    }

    public WelcomeResponseDto hello(WelcomeDto welcomDto) {
        return helloService.hello(welcomDto);
    }
}
