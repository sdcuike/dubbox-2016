package com.doctor.demo.common.dto;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * @author sdcuike
 *
 * @time 2016年2月14日 上午9:43:41
 */
// @JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class WelcomeResponseDto implements Serializable {
    private static final long serialVersionUID = -3767403433492899998L;
    private String content;
    private String fullName;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
