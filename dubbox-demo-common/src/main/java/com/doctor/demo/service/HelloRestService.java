package com.doctor.demo.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.doctor.demo.common.dto.WelcomeDto;
import com.doctor.demo.common.dto.WelcomeResponseDto;
import com.doctor.demo.common.model.ModelResult;

import io.swagger.annotations.ApiOperation;

/**
 * @author sdcuike
 *
 * @time 2016年1月25日 下午11:07:44
 */
@Path("hello")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public interface HelloRestService {
    /**
     * 老接口方式（DTO)
     * xxx不能为空
     * 
     * @param welcomDto
     * @return
     */

    @POST
    @Path("w")
    @ApiOperation(value = "test hello ", notes = "test swagger")
    WelcomeResponseDto hello(WelcomeDto welcomDto);

    @POST
    @Path("m")
    ModelResult<WelcomeResponseDto> test_ModelResult(WelcomeDto welcomeDto);
}
