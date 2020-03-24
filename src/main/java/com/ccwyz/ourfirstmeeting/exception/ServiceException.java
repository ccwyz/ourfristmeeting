package com.ccwyz.ourfirstmeeting.exception;

import com.ccwyz.ourfirstmeeting.enums.ResponseEnum;
import lombok.Data;
import lombok.Getter;

/**
 * @program: ourfristmeeting
 * @description: 自定义统一业务异常
 * @author: Charles_Cao
 * @create: 2020-03-24 14:05
 **/
@Data
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 2130039640356464841L;

    private String code;
    private String message;

    public ServiceException(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public ServiceException(ResponseEnum rse) {
        this.code = rse.getCode();
        this.message = rse.getMessage();
    }

}
