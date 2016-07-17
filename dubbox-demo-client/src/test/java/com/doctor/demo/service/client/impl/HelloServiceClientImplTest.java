package com.doctor.demo.service.client.impl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.junit.Ignore;
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
    public void testHello_para_WelcomeDto() throws InterruptedException {
        int n = 21;
        ExecutorService service = Executors.newFixedThreadPool(50);

        for (int i = 0; i < n; i++) {
            WelcomeDto welcomDto = new WelcomeDto();
            welcomDto.setAge(i);
            welcomDto.setName("doctor who");
            welcomDto.setSleepTime(6L);
            System.err.println("第" + i + "请求");

            service.submit(() -> {
                WelcomeResponseDto welcomeResponseDto = helloService.hello(welcomDto);
                System.err.println(welcomeResponseDto);
            });

        }

        TimeUnit.HOURS.sleep(1);
        service.shutdown();
    }

    @Ignore
    @Test
    public void testHello_para_string() {
        WelcomeResponseDto welcomeResponseDto = helloService.hello("你好");
        System.err.println(welcomeResponseDto);
    }

    @Ignore
    @Test
    public void testHello_para_() {
        WelcomeDto welcomeDto = new WelcomeDto();
        welcomeDto.setAge(10088);
        welcomeDto.setName("doctor who");
        WelcomeResponseDto welcomeResponseDto = helloService.hello("rain", 888, welcomeDto);
        System.err.println(welcomeResponseDto);
    }

}
