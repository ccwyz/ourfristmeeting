package com.ccwyz.ourfirstmeeting.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.ccwyz.ourfirstmeeting.handler.MyMetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @program: ourfristmeeting
 * @description: mybatis-plus的配置类
 * @author: Charles_Cao
 * @create: 2020-03-23 20:23
 **/
@Slf4j
@Configuration
@MapperScan("com.ccwyz.ourfirstmeeting.mapper*")
public class MyBatisPlusConfig {

    /**
    * @Description: 配置分页插件
    * @Param: []
    * @return: com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
    * @Author: Charles_Cao
    * @Date: 2020/3/23
    */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        log.info("注册分页插件");
        return new PaginationInterceptor();
    }

    /**
    * @Description: Sql执行效率插件
    * @Param: []
    * @return: com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor
    * @Author: Charles_Cao
    * @Date: 2020/3/23
    */
    @Bean
    @Profile({"cc"})// 设置 我们各自的环境开启,或者企业中的dev/stg/prd 环境开启
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

   /**
   * @Description: 逻辑删除用，3.1.1之后的版本可不需要配置该bean，但项目这里用的是3.1.0的
   * @Param: []
   * @return: com.baomidou.mybatisplus.core.injector.ISqlInjector
   * @Author: Charles_Cao
   * @Date: 2020/3/23-20:31
   */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    /**
    * @Description: 乐观锁的标志
    * @Param: []
    * @return: com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor
    * @Author: Charles_Cao
    * @Date: 2020/3/24-17:33
    */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }

    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new MyMetaObjectHandler();
    }

}
