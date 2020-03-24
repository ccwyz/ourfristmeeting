package com.ccwyz.ourfirstmeeting.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("heart") //相当于加了@controller和@responsebody ,返回以json格式返回
@Api(value = "心跳检测")
public class HeartController {
    /**
    * @Description: 心跳方法
    * @Param: 返回成功字符串
    * @return: java.lang.String
    * @Author: Charles_Cao
    * @Date: 2020/3/22
    */
    @RequestMapping(value = {"/hello","/hi"},method = RequestMethod.GET)
    @ApiOperation(value = "心跳接口")
    public String heart(){
        return "I'm alive!!!0000";
    }

}
