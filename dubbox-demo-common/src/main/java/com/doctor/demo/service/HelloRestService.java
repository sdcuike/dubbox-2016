package com.doctor.demo.service;

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
@Path("hello")
public interface HelloRestService {
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

}
