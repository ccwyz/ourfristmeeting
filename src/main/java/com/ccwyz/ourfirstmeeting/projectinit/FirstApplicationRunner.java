package com.ccwyz.ourfirstmeeting.projectinit;

/**
 * @program: common
 * @description: 该类会在springboot容器启动后, 执行方法中的内容
 * @author: Charles_Cao
 * @create: 2020-03-23 12:21
 **/

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(value = 1)//表示这个执行的顺序,值越小拥有越高的优先级。
public class FirstApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("-------------应用启动成功!!!application start!!-----------");
    }
}
