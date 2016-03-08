package com.doctor.demo.common.dto;

import java.io.Serializable;

import com.google.gson.Gson;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author sdcuike
 *
 * @time 2016年2月14日 上午9:37:44
 */
@ApiModel(description = "WelcomeDto test @ApiModel")
public class WelcomeDto implements Serializable {
    private static final long serialVersionUID = 5888239832930244489L;

    @ApiModelProperty(required = true, example = "doctor who")
    private String name;

    @ApiModelProperty(required = false, example = "2888")
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
