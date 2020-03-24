package com.ccwyz.ourfirstmeeting.dto.request.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * @program: ourfristmeeting
 * @description: 新增用户dto
 * @author: Charles_Cao
 * @create: 2020-03-24 16:32
 **/
@Data
@ApiModel("新增用户入参")
public class UserInfoCreateDTO {
    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不能为空")
    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty("用户密码")
    @NotBlank(message = "用户密码不能为空")
    private String password;

    /**
     * 年龄
     */
    @ApiModelProperty("用户年龄")
    private Integer age;



}
