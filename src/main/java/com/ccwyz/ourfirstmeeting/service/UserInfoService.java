package com.ccwyz.ourfirstmeeting.service;

import com.ccwyz.ourfirstmeeting.dto.request.common.PageResDTO;
import com.ccwyz.ourfirstmeeting.dto.request.user.UserInfoCreateDTO;
import com.ccwyz.ourfirstmeeting.dto.request.user.UserInfoPageDTO;
import com.ccwyz.ourfirstmeeting.dto.response.UserInfoListDTO;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author Charles_Cao
 * @since 2020-03-23
 */
public interface UserInfoService  {

    void create(UserInfoCreateDTO userInfoCreateDTO);

    PageResDTO<UserInfoListDTO> list(UserInfoPageDTO userInfoPageDTO);
}
