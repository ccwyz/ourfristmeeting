package com.ccwyz.ourfirstmeeting.utils;

import com.ccwyz.ourfirstmeeting.dto.response.RetResult;
import com.ccwyz.ourfirstmeeting.enums.ResponseEnum;
import com.ccwyz.ourfirstmeeting.exception.ServiceException;

/**
 * @program: ourfristmeeting
 * @description: 包装retResult
 * @author: Charles_Cao
 * @create: 2020-03-24 14:44
 **/
public class RetResultUtil {

    public static <T> RetResult<T> success(T t){
        return new RetResult<T>(ResponseEnum.SUCCESS,t);
    }

    public static <T> RetResult<T> success(){
        return new RetResult<T>(ResponseEnum.SUCCESS,null);
    }

    public static <T> RetResult<T> error(ServiceException serviceException,T t){
        return new RetResult<T>(serviceException,t);
    }

    public static <T> RetResult<T> error(ServiceException serviceException){
        return new RetResult<T>(serviceException,null);
    }

    public static <T> RetResult<T> error(String code,String message){
        return new RetResult<T>(code, message);
    }


    public static <T> RetResult<T> error(ResponseEnum methodNotAllowed, T t) {
        return new RetResult<T>(methodNotAllowed,t);
    }

    public static <T> RetResult<T> error(ResponseEnum methodNotAllowed) {
        return error(methodNotAllowed,null);
    }
}
