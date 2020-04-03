package com.ccwyz.ourfirstmeeting.dto.request.user;

import com.ccwyz.ourfirstmeeting.dto.request.common.PageReqDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: ourfristmeeting
 * @description: 用户分页查询DTO
 * @author: Charles_Cao
 * @create: 2020-04-03 11:27
 **/
@Data
public class UserInfoPageDTO extends PageReqDTO {
    @ApiModelProperty("用户名")
    private String userName;

    /**
     * 年龄
     */
    @ApiModelProperty("用户年龄")
    private Integer age;
}
