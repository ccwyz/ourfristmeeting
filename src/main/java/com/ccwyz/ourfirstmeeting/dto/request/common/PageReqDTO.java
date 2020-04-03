package com.ccwyz.ourfirstmeeting.dto.request.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;

/**
 * @program: ourfristmeeting
 * @description: 所有需要分页查询的DTO入参
 * @author: Charles_Cao
 * @create: 2020-04-03 11:01
 **/
@Data
@ApiModel("分页入参")
public class PageReqDTO {

    @ApiModelProperty("当前页码")
    private long currentPageNum;
    @ApiModelProperty("每页查询条数")
    @Max(value = 500,message = "每页展示不超过500条")
    private long pageSize;

    //以下属性方便自定义sql实现分页
    private long limit;

    private long offset;

}
