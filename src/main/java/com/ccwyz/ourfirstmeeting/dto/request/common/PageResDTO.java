package com.ccwyz.ourfirstmeeting.dto.request.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.ConstructorArgs;

import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.List;

/**
 * @program: ourfristmeeting
 * @description: 分页查询出参
 * @author: Charles_Cao
 * @create: 2020-04-03 11:01
 **/
@Data
@ApiModel("分页出参")
@AllArgsConstructor
public class PageResDTO<T> implements Serializable {

    private static final long serialVersionUID = -2134990917074545571L;
    @ApiModelProperty("当前页码")
    private final long currentPageNum;
    @ApiModelProperty("每页查询条数")
    private final long pageSize;
    @ApiModelProperty("总页数")
    private final long pageNums;
    @ApiModelProperty("分页数据")
    private final List<T> content;
    @ApiModelProperty("总条数")
    private final long total;

    public boolean hasContent(){
        return content!=null&&content.size()>0;
    }
}
