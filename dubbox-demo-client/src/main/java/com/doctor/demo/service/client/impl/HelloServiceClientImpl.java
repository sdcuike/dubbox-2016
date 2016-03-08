package com.doctor.demo.service.client.impl;

import java.util.List;

import com.doctor.demo.common.domain.WorkflowSetting;
import com.doctor.demo.common.dto.WelcomeDto;
import com.doctor.demo.common.dto.WelcomeResponseDto;
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

    @Override
    public WelcomeResponseDto hello(String name) {
        return helloService.hello(name);
    }

    @Override
    public WelcomeResponseDto hello(String name, int age, WelcomeDto welcomeDto) {
        return helloService.hello(name, age, welcomeDto);
    }

    @Override
    public List<WelcomeResponseDto> test_list(String name, int age, List<WelcomeDto> welcomeDtos) {
        return helloService.test_list(name, age, welcomeDtos);
    }

    @Override
    public Boolean createWorkflowSetting(List<WorkflowSetting> userList) {
        return helloService.createWorkflowSetting(userList);
    }

}
