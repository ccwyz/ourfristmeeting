package com.ccwyz.ourfirstmeeting.controller;


import com.ccwyz.ourfirstmeeting.dto.request.user.UserInfoCreateDTO;
import com.ccwyz.ourfirstmeeting.dto.response.RetResult;
import com.ccwyz.ourfirstmeeting.service.UserInfoService;
import com.ccwyz.ourfirstmeeting.utils.RetResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author Charles_Cao
 * @since 2020-03-24
 */
@Api(value = "用户模块")
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation(value = "新增用户")
    @RequestMapping(value = {"/create"},method = RequestMethod.POST)
    public RetResult create(@RequestBody  @Valid UserInfoCreateDTO userInfoCreateDTO){
        userInfoService.create(userInfoCreateDTO);
        return RetResultUtil.success();
    }
}
