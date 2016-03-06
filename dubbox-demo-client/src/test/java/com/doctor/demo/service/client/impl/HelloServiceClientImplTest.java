package com.doctor.demo.service.client.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
@ContextConfiguration("classpath:/META-INF/spring/main.xml")
public class HelloServiceClientImplTest {

    @Resource(name = "helloServiceClient")
    private HelloService helloService;

    @Test
    public void testHello_para_WelcomeDto() {
        WelcomeDto welcomDto = new WelcomeDto();
        welcomDto.setAge(10088);
        welcomDto.setName("doctor who");
        WelcomeResponseDto welcomeResponseDto = helloService.hello(welcomDto);
        System.err.println(welcomeResponseDto);
    }

    @Test
    public void testHello_para_string() {
        WelcomeResponseDto welcomeResponseDto = helloService.hello("你好");
        System.err.println(welcomeResponseDto);
    }

    @Test
    public void testHello_para_() throws InterruptedException {
        WelcomeDto welcomeDto = new WelcomeDto();
        welcomeDto.setAge(10088);
        welcomeDto.setName("doctor who");
        WelcomeResponseDto welcomeResponseDto = helloService.hello("rain", 888, welcomeDto);
        System.err.println(welcomeResponseDto);
        TimeUnit.SECONDS.sleep(100);
    }

    @Test
    public void test_test() {
        List<WelcomeDto> welcomeDtos = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            WelcomeDto welcomeDto = new WelcomeDto();
            welcomeDto.setAge(i);
            welcomeDto.setName("doctor who " + i);
            welcomeDtos.add(welcomeDto);
        }
        List<WelcomeResponseDto> list = helloService.test(welcomeDtos);
        System.err.println(list);
    }

}
