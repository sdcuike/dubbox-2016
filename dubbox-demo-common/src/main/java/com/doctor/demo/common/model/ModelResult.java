package com.doctor.demo.common.model;

import java.io.Serializable;

/**
 * @author sdcuike
 *
 * @time 2016年3月8日 上午10:46:46
 */
public class ModelResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String rescode;

    private String errcode;

    private String errmsg;
    private T data;
    private boolean success = true;

    public ModelResult() {

    }

    public ModelResult(String rescode, String errcode, String errmsg) {
        this.rescode = rescode;
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.success = false;
    }

    public String getRescode() {
        return rescode;
    }

    public void setRescode(String rescode) {
        this.rescode = rescode;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
        this.success = false;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
        this.success = false;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

}
