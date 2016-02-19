package com.doctor.demo.service.client.impl;

import java.util.concurrent.TimeUnit;

import com.alibaba.dubbo.container.spring.SpringContainer;
import com.doctor.demo.common.dto.WelcomeDto;
import com.doctor.demo.common.dto.WelcomeResponseDto;
import com.doctor.demo.service.HelloService;

public class HelloServiceClientImpl2Test {

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> com.alibaba.dubbo.container.Main.main(args)).start();
        new Thread(HelloServiceClientImpl2Test::run).start();

    }

    public static void run() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            HelloService helloService = (HelloService) SpringContainer.getContext().getBean("helloServiceClient");

            WelcomeDto welcomDto = new WelcomeDto();
            welcomDto.setAge(10088);
            welcomDto.setName("doctor who");
            WelcomeResponseDto welcomeResponseDto = helloService.hello(welcomDto);
            System.err.println(welcomeResponseDto);

            welcomeResponseDto = helloService.hello("你好");
            System.err.println(welcomeResponseDto);

            welcomeResponseDto = helloService.hello("rain", 888, welcomDto);
            System.err.println(welcomeResponseDto);
        }

    }

}
