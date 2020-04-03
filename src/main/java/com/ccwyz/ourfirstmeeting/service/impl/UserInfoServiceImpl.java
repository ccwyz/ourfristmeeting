package com.ccwyz.ourfirstmeeting.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ccwyz.ourfirstmeeting.domain.entity.UserInfoEntity;
import com.ccwyz.ourfirstmeeting.dto.request.common.PageResDTO;
import com.ccwyz.ourfirstmeeting.dto.request.user.UserInfoCreateDTO;
import com.ccwyz.ourfirstmeeting.dto.request.user.UserInfoPageDTO;
import com.ccwyz.ourfirstmeeting.dto.response.UserInfoListDTO;
import com.ccwyz.ourfirstmeeting.mapper.UserInfoMapper;
import com.ccwyz.ourfirstmeeting.service.UserInfoService;
import com.ccwyz.ourfirstmeeting.utils.DataBaseVerifyUtil;
import com.ccwyz.ourfirstmeeting.utils.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
       // createSomeUser(20);
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        BeanUtils.copyProperties(userInfoCreateDTO,userInfoEntity);
        log.info("新增用户---start,参数:{}",userInfoEntity);
        int count = userInfoMapper.insert(userInfoEntity);
        DataBaseVerifyUtil.insertOrUpdateOneSuccess(count);
        log.info("新增用户---end,参数:{}",userInfoEntity);

        integer = userInfoMapper.selectCount(wrapper);
        log.info("库里后有{}条数据",integer);
    }

    @Override
    public PageResDTO<UserInfoListDTO> list(UserInfoPageDTO userInfoPageDTO) {
        Page<UserInfoEntity> page = PageUtil.getPageAndAssembleParameter(userInfoPageDTO);
        LambdaQueryWrapper<UserInfoEntity> lqw = new LambdaQueryWrapper<>();
        lqw.like(userInfoPageDTO.getUserName()!=null,UserInfoEntity::getUserName,userInfoPageDTO.getUserName()).eq(userInfoPageDTO.getAge()!=null,UserInfoEntity::getAge,
                userInfoPageDTO.getAge());
        Integer total = userInfoMapper.selectCount(lqw);
        if(total==null||total==0){
            return PageUtil.getPageResDTOButNoData(userInfoPageDTO);
        }
        IPage<UserInfoEntity> userInfoEntityIPage = userInfoMapper.selectPage(page, lqw);
        return PageUtil.copeIPageToPageResDTO(userInfoEntityIPage,UserInfoListDTO.class);
    }

//    @Override
//    //测试mybatis的一个坑
//    public PageResDTO<UserInfoListDTO> list2(UserInfoPageDTO userInfoPageDTO) {
//
//        LambdaQueryWrapper<UserInfoEntity> lqw = new LambdaQueryWrapper<>();
//        lqw.like(userInfoPageDTO.getUserName()!=null,UserInfoEntity::getUserName,userInfoPageDTO.getUserName()).eq(userInfoPageDTO.getAge()!=null,UserInfoEntity::getAge,
//                userInfoPageDTO.getAge());
//        Integer total = userInfoMapper.selectCount(lqw);
//        int start = 1;
//        long size = userInfoPageDTO.getPageSize();
//        long pages =1+(total-1)/size;
//        while(start<=pages){
//            Page<UserInfoEntity> page = new Page<>(start,size);
//            IPage<UserInfoEntity> userInfoEntityIPage = userInfoMapper.selectPage(page, lqw);
//            log.info(JSON.toJSONString(userInfoEntityIPage.getRecords()));
//            start++;
//        }
//        return null;
//    }
    /**
    * @Description: 创建多个用户,为分页做准备
    * @Param: [howMany]
    * @return: void
    * @Author: Charles_Cao
    * @Date: 2020/4/4-0:01
    */
    public void createSomeUser(int howMany){
        int count =0;
        while(count<howMany){
            UserInfoEntity userInfoEntity = new UserInfoEntity();
            userInfoEntity.setUserName("userName"+count);
            userInfoEntity.setAge(count);
            userInfoEntity.setPassword("passwords"+count);
            log.info("新增用户---start,参数:{}",userInfoEntity);
            int createCount = userInfoMapper.insert(userInfoEntity);
            DataBaseVerifyUtil.insertOrUpdateOneSuccess(createCount);
            log.info("新增用户---end,参数:{}",userInfoEntity);
            count++;
        }
    }


}
