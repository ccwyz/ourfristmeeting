package com.ccwyz.ourfirstmeeting.exception;

import com.ccwyz.ourfirstmeeting.dto.response.RetResult;
import com.ccwyz.ourfirstmeeting.enums.ResponseEnum;
import com.ccwyz.ourfirstmeeting.utils.RetResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * @program: ourfristmeeting
 * @description: 全局异常统一处理
 * @author: Charles_Cao
 * @created: 2020-03-24 14:04
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {
    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ServiceException.class})
    public RetResult<?> handleServiceException(ServiceException e) {
        log.error("业务异常", e);
        return RetResultUtil.error(e);
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({HttpMessageNotReadableException.class, MissingServletRequestParameterException.class,
            BindException.class,
            ServletRequestBindingException.class, MethodArgumentNotValidException.class, ConstraintViolationException.class})
    public RetResult<?> handleHttpMessageNotReadableException(Exception e) {
        log.error("参数解析失败", e);
        if (e instanceof BindException){
            return RetResultUtil.error(ResponseEnum.BAD_REQUEST.getCode(),
                    ((BindException)e).getAllErrors().get(0).getDefaultMessage());
        }
        return RetResultUtil.error(ResponseEnum.BAD_REQUEST.getCode(), e.getMessage());
    }

    /**
     * 405 - Method Not Allowed
     * 带有@ResponseStatus注解的异常类会被ResponseStatusExceptionResolver 解析
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public RetResult<?> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("不支持当前请求方法", e);
        return RetResultUtil.error(ResponseEnum.METHOD_NOT_ALLOWED, null);
    }

    /**
    * @Description: 其他全局异常在此捕获
    * @Param: [e]
    * @return: com.ccwyz.ourfirstmeeting.dto.response.RetResult<?>
    * @Author: Charles_Cao
    * @Date: 2020/3/24-15:54
    */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public RetResult<?> handleException(Throwable e) {
        log.error("服务运行异常", e);
        return RetResultUtil.error(ResponseEnum.INTERNAL_SERVER_ERROR);
    }

}
