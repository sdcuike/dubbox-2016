package com.doctor.demo.service.client.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.doctor.demo.common.dto.WelcomeDto;
import com.doctor.demo.common.dto.WelcomeResponseDto;
import com.doctor.demo.service.HelloService;

/**
 * 
 * @author sdcuike
 *
 * @time 2016年1月27日 下午1:52:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/demoClientConfig/spring-context.xml")
public class HelloServiceClientImplTest {

    @Resource(name = "helloServiceClient")
    private HelloService helloService;

    @Test
    public void testHello() {
        WelcomeDto welcomDto = new WelcomeDto();
        welcomDto.setAge(10088);
        welcomDto.setName("doctor who");
        WelcomeResponseDto welcomeResponseDto = helloService.hello(welcomDto);
        System.err.println(welcomeResponseDto);
    }

}
