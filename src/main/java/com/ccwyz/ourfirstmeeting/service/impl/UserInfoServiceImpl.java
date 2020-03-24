package com.ccwyz.ourfirstmeeting.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ccwyz.ourfirstmeeting.domain.entity.UserInfoEntity;
import com.ccwyz.ourfirstmeeting.dto.request.user.UserInfoCreateDTO;
import com.ccwyz.ourfirstmeeting.mapper.UserInfoMapper;
import com.ccwyz.ourfirstmeeting.service.UserInfoService;
import com.ccwyz.ourfirstmeeting.utils.DataBaseVerifyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author Charles_Cao
 * @since 2020-03-24
 */
@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void create(UserInfoCreateDTO userInfoCreateDTO) {
        LambdaQueryWrapper<UserInfoEntity> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(UserInfoEntity::getIsValid,1);
        Integer integer = userInfoMapper.selectCount(wrapper);
        log.info("库里前有{}条数据",integer);
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        BeanUtils.copyProperties(userInfoCreateDTO,userInfoEntity);
        log.info("新增用户---start,参数:{}",userInfoEntity);
        int count = userInfoMapper.insert(userInfoEntity);
        DataBaseVerifyUtil.insertOrUpdateOneSuccess(count);
        log.info("新增用户---end,参数:{}",userInfoEntity);

        integer = userInfoMapper.selectCount(wrapper);
        log.info("库里后有{}条数据",integer);
    }
}
