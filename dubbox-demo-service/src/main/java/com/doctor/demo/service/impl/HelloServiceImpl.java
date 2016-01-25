package com.doctor.demo.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.doctor.demo.service.HelloService;

/**
 * @author sdcuike
 *
 * @time 2016年1月25日 下午11:15:44
 */
@Path("hello")
public class HelloServiceImpl implements HelloService {

    @POST
    @Path("get")
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public String hello(String name) {

        return "doctor who";
    }

}
