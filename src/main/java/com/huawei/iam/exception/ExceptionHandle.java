package com.huawei.iam.exception;

import com.huawei.iam.dto.HttpResult;
import com.huawei.iam.util.HttpUtil;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhouyibin on 2017/12/31.
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public HttpResult handle(Exception e){

        if(e instanceof IAMException){
            IAMException iamException = (IAMException)e;
            return HttpUtil.error(iamException.getCode(), iamException.getMessage());
        }

        if(e instanceof MethodArgumentNotValidException){
            ExceptionEnum exceptionEnum = ExceptionEnum.PARAMETER_UNVALID;
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException)e;
            methodArgumentNotValidException.getBindingResult().getFieldError().getDefaultMessage();
            return HttpUtil.error(exceptionEnum.getCode(),exceptionEnum.getMessage() + ":" + methodArgumentNotValidException.getBindingResult().getFieldError().getDefaultMessage());
        }

        return HttpUtil.error(ExceptionEnum.UNKNOW_ERROR.getCode(), ExceptionEnum.UNKNOW_ERROR.getMessage());
    }
}
