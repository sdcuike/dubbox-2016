package com.doctor.demo.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.doctor.demo.common.dto.WelcomeDto;
import com.doctor.demo.common.dto.WelcomeResponseDto;

/**
 * @author sdcuike
 *
 * @time 2016年1月25日 下午11:07:44
 */

@Path("hs")
public interface HelloService {
    /**
     * 老接口方式（DTO)
     * 
     * @param welcomDto
     * @return
     */
    @POST
    @Path("w")
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    WelcomeResponseDto hello(WelcomeDto welcomDto);

    /**
     * 其它
     * 
     * @param name
     * @return
     */
    WelcomeResponseDto hello(String name);

    WelcomeResponseDto hello(String name, int age, WelcomeDto welcomeDto);

    List<WelcomeResponseDto> test_list(String name, int age, List<WelcomeDto> welcomeDtos);

}
