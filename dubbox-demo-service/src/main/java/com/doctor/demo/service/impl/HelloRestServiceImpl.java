package com.doctor.demo.service.impl;

import com.doctor.demo.common.dto.WelcomeDto;
import com.doctor.demo.common.dto.WelcomeResponseDto;
import com.doctor.demo.common.model.ModelResult;
import com.doctor.demo.service.HelloRestService;

/**
 * @author sdcuike
 *
 * @time 2016年1月25日 下午11:15:44
 */
public class HelloRestServiceImpl implements HelloRestService {

    @Override
    public WelcomeResponseDto hello(WelcomeDto welcomDto) {
        // TODO:入参条件校验
        WelcomeResponseDto welcomeResponseDto = new WelcomeResponseDto();
        welcomeResponseDto.setContent("welcome to dubbox rest, you name:" + welcomDto.getName() + " your age:" + welcomDto.getAge());
        return welcomeResponseDto;
    }

    @Override
    public ModelResult<WelcomeResponseDto> test_ModelResult(WelcomeDto welcomeDto) {
        WelcomeResponseDto welcomeResponseDto = new WelcomeResponseDto();
        welcomeResponseDto.setContent("welcome to dubbo," + welcomeDto.getName() + " ,your age :" + welcomeDto.getAge() + " " + welcomeDto);
        welcomeResponseDto.setFullName("which doctor");
        ModelResult<WelcomeResponseDto> modelResult = new ModelResult<>();
        modelResult.setData(welcomeResponseDto);
        return modelResult;
    }

}
