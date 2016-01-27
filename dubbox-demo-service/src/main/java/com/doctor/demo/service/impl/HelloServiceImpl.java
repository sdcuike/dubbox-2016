package com.doctor.demo.service.impl;

import com.doctor.demo.service.HelloService;

/**
 * @author sdcuike
 *
 * @time 2016年1月25日 下午11:15:44
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {

        return "welcom to home ," + name;
    }

}
