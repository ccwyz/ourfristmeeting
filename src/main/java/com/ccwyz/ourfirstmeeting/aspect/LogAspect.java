package com.ccwyz.ourfirstmeeting.aspect;

import com.alibaba.fastjson.JSON;
import com.ccwyz.ourfirstmeeting.constant.LogConst;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: ourfristmeeting
 * @description: 全局controller日志打印
 * @author: Charles_Cao
 * @create: 2020-03-24 11:38
 **/
@Slf4j
@Configuration
@Aspect
public class LogAspect {

    @Around(LogConst.LOG_DATA_POINT)
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        log.info("### <<<---------------------------------LOG Start------------------------------->>>");
        ServletRequestAttributes requestAttributes =(ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //打印请求的url
        log.info("### URL                 :{}",request.getRequestURL().toString());
        //打印请求方法名
        log.info("### HTTP Method         :{}",request.getMethod());
        //打印调用controller的全部路径
        log.info("### Class Method        :{}.{}",proceedingJoinPoint.getSignature().getDeclaringTypeName(),
                proceedingJoinPoint.getSignature().getName());
        //打印请求的IP
        log.info("### IP                  :{}", request.getRemoteAddr());
        //打印入参
        log.info("### Request Args        :{}", JSON.toJSONString(proceedingJoinPoint.getArgs()));

        Object obj = proceedingJoinPoint.proceed();
        //打印出参
        log.info("### Response Args       :{}", JSON.toJSONString(obj));
        log.info("### <<<---------------------------------LOG End------------------------------->>>");
        return obj;
    }
}
