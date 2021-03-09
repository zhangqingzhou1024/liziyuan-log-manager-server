package com.liziyuan.hope.log.manager.core.utils.user;

import com.liziyuan.hope.log.manager.core.model.UserInfo;

/**
 * 用户工具类
 *
 * @author zqz
 * @version 1.0
 * @date 2020-09-21 14:44
 */
public class UserUtils {


    /**
     * 获取用户信息
     * 包括：
     * 用户名
     * 登录账号
     * 是否为系统超级管理员权限
     *
     * @return 用户信息
     */
    public static UserInfo getUserInfo() {
        // TODO get user info

        return UserInfo.builder().build();
    }

}
