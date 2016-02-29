package com.doctor.demo.manager.impl;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author sdcuike
 *
 * @time 2016年2月29日 下午3:47:23
 */
@Configuration
@ImportResource({ "classpath:/demoClientConfig/spring-context.xml", "classpath:/dubbo-application-config.xml", "classpath:/dubbxBraveConfig/*-brave.xml" })
public class ManagerConfiguration {

}
