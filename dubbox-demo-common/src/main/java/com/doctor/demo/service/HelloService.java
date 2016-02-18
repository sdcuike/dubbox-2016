package com.doctor.demo.service;

import com.doctor.demo.common.dto.WelcomeDto;
import com.doctor.demo.common.dto.WelcomeResponseDto;

/**
 * @author sdcuike
 *
 * @time 2016年1月25日 下午11:07:44
 */
public interface HelloService {
    /**
     * 老接口方式（DTO)
     * 
     * @param welcomDto
     * @return
     */
    WelcomeResponseDto hello(WelcomeDto welcomDto);

    /**
     * 其它
     * 
     * @param name
     * @return
     */
    WelcomeResponseDto hello(String name);

    WelcomeResponseDto hello(String name, int age, WelcomeDto welcomeDto);
}
