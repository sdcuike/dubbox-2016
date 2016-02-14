package com.doctor.demo.service;

import com.doctor.demo.common.dto.WelcomeResponseDto;
import com.doctor.demo.common.dto.WelcomeDto;

/**
 * @author sdcuike
 *
 * @time 2016年1月25日 下午11:07:44
 */
public interface HelloService {
    WelcomeResponseDto hello(WelcomeDto welcomDto);
}
