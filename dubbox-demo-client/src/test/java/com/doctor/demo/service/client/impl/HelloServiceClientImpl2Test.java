package com.doctor.demo.service.client.impl;

import java.util.concurrent.TimeUnit;

import com.alibaba.dubbo.container.spring.SpringContainer;
import com.doctor.demo.service.HelloService;

public class HelloServiceClientImpl2Test {

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> com.alibaba.dubbo.container.Main.main(args)).start();

        TimeUnit.SECONDS.sleep(10);
        HelloService helloService = (HelloService) SpringContainer.getContext().getBean("helloServiceClient");
        String hello = helloService.hello("doctor who !!!");
        System.err.println(hello);
    }

}
