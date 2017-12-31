package com.huawei.iam.exception;

/**
 * Created by zhouyibin on 2017/12/31.
 */
public enum ExceptionEnum {
    UNKNOW_ERROR(-1, "unknow error"),
    CUSTOME_ERROR(1, "custome error"),
    PARAMETER_UNVALID(2, "parameter unvalid");


    private Integer code;
    private String message;

    ExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
