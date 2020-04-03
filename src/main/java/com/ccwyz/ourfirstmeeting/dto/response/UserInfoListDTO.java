package com.ccwyz.ourfirstmeeting.dto.response;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * @program: ourfristmeeting
 * @description: 分页查询返回列表DTO
 * @author: Charles_Cao
 * @create: 2020-04-03 15:58
 **/
@Data
public class UserInfoListDTO {
    @ApiModelProperty("用户名")
    private String userName;

    /**
     * 年龄
     */
    @ApiModelProperty("用户年龄")
    private Integer age;

    /**
     * 主键
     */
    @ApiModelProperty("用户id")
    private Integer id;


    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String createdBy;

    /**
     * 修改人
     */
    @ApiModelProperty("修改人")
    private String updatedBy;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createdDate;

    /**
     * 修改时间
     */
    @ApiModelProperty("更新时间")
    private LocalDateTime updatedDate;



}
