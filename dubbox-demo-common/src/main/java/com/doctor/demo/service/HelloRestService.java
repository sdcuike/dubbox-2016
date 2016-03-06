package com.doctor.demo.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.doctor.demo.common.dto.WelcomeDto;
import com.doctor.demo.common.dto.WelcomeResponseDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

/**
 * @author sdcuike
 *
 * @time 2016年1月25日 下午11:07:44
 */
@Api(value = "hello", tags = "hello service")
@Path("hello")
public interface HelloRestService {
    /**
     * 老接口方式（DTO)
     * 
     * @param welcomDto
     * @return
     */
    @ApiOperation(value = "test hello method", notes = "note")

    @POST
    @Path("w")
    @Consumes({ MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_JSON })
    @ApiResponse(message = "ok", code = 200)
    WelcomeResponseDto hello(@ApiParam(value = "welcomDto object", required = true) WelcomeDto welcomDto);

}
