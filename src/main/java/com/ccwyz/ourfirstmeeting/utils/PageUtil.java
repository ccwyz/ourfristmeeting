package com.ccwyz.ourfirstmeeting.utils;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ccwyz.ourfirstmeeting.domain.entity.UserInfoEntity;
import com.ccwyz.ourfirstmeeting.dto.request.common.PageReqDTO;
import com.ccwyz.ourfirstmeeting.dto.request.common.PageResDTO;
import com.ccwyz.ourfirstmeeting.dto.response.UserInfoListDTO;
import com.ccwyz.ourfirstmeeting.enums.ResponseEnum;
import com.ccwyz.ourfirstmeeting.exception.ServiceException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: ourfristmeeting
 * @description: 封装分页查询对象
 * @author: Charles_Cao
 * @create: 2020-04-03 16:34
 **/
@Slf4j
public class PageUtil {
    /**
    * @Description: 根据入参生成page对象
    * @Param: [t] extends PageReqDTO
    * @return: com.baomidou.mybatisplus.extension.plugins.pagination.Page<Q>
    * @Author: Charles_Cao
    * @Date: 2020/4/3-21:42
    */
    public static <T extends PageReqDTO,Q > Page<Q> getPageAndAssembleParameter(T t){
        Page<Q> page = new Page<>();
        page.setSize(t.getPageSize());
        page.setCurrent(t.getCurrentPageNum());
        return page;
    }

    public static <T,Q > PageResDTO<Q> copeIPageToPageResDTO(IPage<T>  iPage,Class<Q> qClass){
        if(iPage==null||qClass==null){
            return null;
        }
        List<T> records = iPage.getRecords();
        List<Q> recordsList = null;
        if(!CollectionUtils.isEmpty(records)){
            recordsList = new ArrayList<>();
            for(T t:records){
                try {
                    Q q = qClass.newInstance();
                    BeanUtils.copyProperties(t,q);
                    recordsList.add(q);
                } catch (Exception e) {
                    log.error("新建page返回对象失败");
                    throw new ServiceException(ResponseEnum.NEW_INSTANCE_BY_CLASS_ERROR);
                }
            }
        }
        return new PageResDTO<Q>(iPage.getCurrent(),iPage.getSize(),iPage.getPages(),recordsList,iPage.getTotal());
    }

    public static <T extends PageReqDTO,Q >  PageResDTO<Q> getPageResDTOButNoData(T t){
        log.info("查询数据为空,入参为{}", JSON.toJSONString(t));
        return new PageResDTO<Q>(t.getCurrentPageNum(),t.getPageSize(),0,null,0);
    }
}
