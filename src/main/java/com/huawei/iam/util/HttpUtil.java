package com.huawei.iam.util;

import com.huawei.iam.dto.HttpResult;

/**
 * Created by zhouyibin on 2017/12/31.
 */
public class HttpUtil {

    private static final int SUCCESS_CODE = 0;
    private static final String SUCCESS_MESSAGE = "success";

    public static HttpResult success(Object o){
        HttpResult result = new HttpResult();
        result.setCode(SUCCESS_CODE);
        result.setMessage(SUCCESS_MESSAGE);
        result.setData(o);
        return result;
    }

    public static HttpResult success(){
        return success(null);
    }

    public static HttpResult error(int code, String message){
        HttpResult result = new HttpResult();
        result.setCode(code);
        result.setMessage(message);
        result.setData(null);
        return result;
    }
}
