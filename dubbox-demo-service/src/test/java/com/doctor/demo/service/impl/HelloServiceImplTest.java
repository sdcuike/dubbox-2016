package com.doctor.demo.service.impl;

import com.alibaba.dubbo.container.spring.SpringContainer;

public class HelloServiceImplTest {

    public static void main(String[] args) {
        SpringContainer springContainer = new com.alibaba.dubbo.container.spring.SpringContainer();
        springContainer.start();
    }
}