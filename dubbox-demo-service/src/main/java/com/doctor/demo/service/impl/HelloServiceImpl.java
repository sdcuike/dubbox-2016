package com.doctor.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.doctor.demo.common.dto.WelcomeDto;
import com.doctor.demo.common.dto.WelcomeResponseDto;
import com.doctor.demo.common.model.ModelResult;
import com.doctor.demo.service.HelloService;

/**
 * @author sdcuike
 *
 * @time 2016年1月25日 下午11:15:44
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public WelcomeResponseDto hello(WelcomeDto welcomDto) {
        // TODO:入参条件校验
        WelcomeResponseDto welcomeResponseDto = new WelcomeResponseDto();
        welcomeResponseDto.setContent("welcome to dubbo," + welcomDto.toString());
        return welcomeResponseDto;
    }

    @Override
    public WelcomeResponseDto hello(String name) {
        // TODO:入参条件校验
        WelcomeResponseDto welcomeResponseDto = new WelcomeResponseDto();
        welcomeResponseDto.setContent("welcome to dubbo," + name);
        return welcomeResponseDto;
    }

    @Override
    public WelcomeResponseDto hello(String name, int age, WelcomeDto welcomeDto) {
        // TODO:入参条件校验
        WelcomeResponseDto welcomeResponseDto = new WelcomeResponseDto();
        welcomeResponseDto.setContent("welcome to dubbo," + name + " ,your age :" + age + " " + welcomeDto);
        return welcomeResponseDto;
    }

    @Override
    public ModelResult<WelcomeResponseDto> test_ModelResult(WelcomeDto welcomeDto) {
        WelcomeResponseDto welcomeResponseDto = new WelcomeResponseDto();
        welcomeResponseDto.setContent("welcome to dubbo," + welcomeDto.getName() + " ,your age :" + welcomeDto.getAge() + " " + welcomeDto);
        ModelResult<WelcomeResponseDto> modelResult = new ModelResult<>();
        modelResult.setData(welcomeResponseDto);
        return modelResult;
    }

    @Override
    public List<WelcomeResponseDto> test(List<WelcomeDto> welcomeDtos) {
        List<WelcomeResponseDto> welcomeResponseDtos = new ArrayList<>();

        for (WelcomeDto welcomeDto : welcomeDtos) {
            WelcomeResponseDto welcomeResponseDto = new WelcomeResponseDto();
            welcomeResponseDto.setContent(welcomeDto.getName() + " " + welcomeDto.getAge());
            welcomeResponseDtos.add(welcomeResponseDto);
        }
        return welcomeResponseDtos;
    }

}
