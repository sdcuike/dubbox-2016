package com.doctor.demo.service.client.impl;

import com.doctor.demo.common.dto.WelcomeResponseDto;
import com.doctor.demo.common.dto.WelcomeDto;
import com.doctor.demo.service.HelloService;

/**
 * @author sdcuike
 *
 * @time 2016年1月27日 上午11:17:28
 */
public class HelloServiceClientImpl implements HelloService {

    private HelloService helloService;

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public WelcomeResponseDto hello(WelcomeDto welcomDto) {
        return helloService.hello(welcomDto);
    }

}
