package com.ccwyz.ourfirstmeeting.dto.response;

import com.alibaba.druid.util.StringUtils;
import com.ccwyz.ourfirstmeeting.enums.ResponseEnum;
import com.ccwyz.ourfirstmeeting.exception.ServiceException;
import com.ccwyz.ourfirstmeeting.utils.TimeUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.DocFlavor;

/**
 * @program: ourfristmeeting
 * @description: 统一返回参数
 * @author: Charles_Cao
 * @create: 2020-03-24 14:34
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "统一返回类")
public class RetResult<T> {
    @ApiModelProperty(value = "响应码",name = "code")
    public String code;
    @ApiModelProperty(value ="响应信息" ,name="message")
    private String message;
    @ApiModelProperty(value ="响应数据" ,name="data")
    private T data;
    @ApiModelProperty(value ="响应时间" ,name="reTime")
    private String reTime;

    public RetResult(ResponseEnum rse,T data) {
        this.code = rse.getCode();
        this.message = rse.getMessage();
        this.data = data;
        this.reTime = TimeUtil.getCurrentTimeString(TimeUtil.TIME_FORMAT);
    }

    public RetResult(ResponseEnum rse) {
        this.code = rse.getCode();
        this.message = rse.getMessage();
        this.data = null;
        this.reTime = TimeUtil.getCurrentTimeString(TimeUtil.TIME_FORMAT);
    }

    public RetResult(ServiceException serviceException,T data) {
        this.code = serviceException.getCode();
        this.message = serviceException.getMessage();
        this.data = data;
        this.reTime = TimeUtil.getCurrentTimeString(TimeUtil.TIME_FORMAT);
    }

    public RetResult(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
