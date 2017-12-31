package com.huawei.iam.exception;

/**
 * Created by zhouyibin on 2017/12/31.
 */
public class IAMException extends RuntimeException {

    private Integer code;

    public IAMException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
