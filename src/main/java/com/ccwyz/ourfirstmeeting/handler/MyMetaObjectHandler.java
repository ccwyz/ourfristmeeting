package com.ccwyz.ourfirstmeeting.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.ccwyz.ourfirstmeeting.constant.MybatisPlusConst;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @program: ourfristmeeting
 * @description: mybatis的自动填充
 * @author: Charles_Cao
 * @create: 2020-03-24 10:11
 **/
//@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    //新增填充
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName(MybatisPlusConst.IS_VALID,MybatisPlusConst.ONE_INTEGER,metaObject);
        this.setFieldValByName(MybatisPlusConst.VERSION,MybatisPlusConst.ONE_LONG,metaObject);
        this.setFieldValByName(MybatisPlusConst.CREATED_DATE, LocalDateTime.now(),metaObject);
        this.setFieldValByName(MybatisPlusConst.UPDATED_DATE,LocalDateTime.now(),metaObject);
        if(this.getFieldValByName(MybatisPlusConst.CREATED_BY,metaObject)==null){
            //todo 这里之后要写入当前登录人信息
            this.setFieldValByName(MybatisPlusConst.CREATED_BY,MybatisPlusConst.DEFAULT_CREATED_BY,metaObject);
        }
        if(this.getFieldValByName(MybatisPlusConst.UPDATED_BY,metaObject)==null){
            //todo 这里之后要写入当前登录人信息
            this.setFieldValByName(MybatisPlusConst.UPDATED_BY,MybatisPlusConst.DEFAULT_UPDATED_BY,metaObject);
        }

    }


    //更新填充
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName(MybatisPlusConst.UPDATED_DATE,new Date(),metaObject);
        if(this.getFieldValByName(MybatisPlusConst.UPDATED_BY,metaObject)==null){
            //todo 这里之后要写入当前登录人信息
            this.setFieldValByName(MybatisPlusConst.UPDATED_BY,MybatisPlusConst.DEFAULT_UPDATED_BY,metaObject);
        }
    }
}

