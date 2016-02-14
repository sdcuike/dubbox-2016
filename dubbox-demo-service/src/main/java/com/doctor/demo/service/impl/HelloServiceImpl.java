package com.doctor.demo.service.impl;

import com.doctor.demo.common.dto.WelcomeResponseDto;
import com.doctor.demo.common.dto.WelcomeDto;
import com.doctor.demo.service.HelloService;

/**
 * @author sdcuike
 *
 * @time 2016年1月25日 下午11:15:44
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public WelcomeResponseDto hello(WelcomeDto welcomDto) {
        WelcomeResponseDto welcomeResponseDto = new WelcomeResponseDto();
        welcomeResponseDto.setContent("welcome to dubbo," + welcomDto.toString());
        return welcomeResponseDto;
    }

}
