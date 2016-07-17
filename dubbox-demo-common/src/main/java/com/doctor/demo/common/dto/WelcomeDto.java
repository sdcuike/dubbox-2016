package com.doctor.demo.common.dto;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * @author sdcuike
 *
 * @time 2016年2月14日 上午9:37:44
 */
public class WelcomeDto implements Serializable {
    private static final long serialVersionUID = 5888239832930244489L;
    private String name;
    private int age;
    private Long sleepTime;

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

    public Long getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(Long sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
