package com.ccwyz.ourfirstmeeting.utils;

import com.ccwyz.ourfirstmeeting.enums.ResponseEnum;
import com.ccwyz.ourfirstmeeting.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: ourfristmeeting
 * @description: 数据库执行校验
 * @author: Charles_Cao
 * @create: 2020-03-24 16:56
 **/
@Slf4j
public class DataBaseVerifyUtil {
    public static void insertOrUpdateOneSuccess(Integer count){
        if(count==null||count!=1){
            log.warn(ResponseEnum.DB_INSERT_OR_UPDATE_ERROR.getMessage()+",返回操作条数:{}",count);
            throw new ServiceException(ResponseEnum.DB_INSERT_OR_UPDATE_ERROR);
        }

    }
}
