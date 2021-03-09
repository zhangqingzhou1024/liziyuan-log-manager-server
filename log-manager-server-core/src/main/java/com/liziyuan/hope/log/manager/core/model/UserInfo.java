package com.liziyuan.hope.log.manager.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户信息
 *
 * @author zqz
 * @version 1.0
 * @date 2020-04-30 15:26
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

    /**
     * 用户ID，暂不提供
     */
    private String id;

    /**
     * 用户名称（可中文）
     */
    private String name;

    /**
     * 英文账户（查询使用）
     */
    private String account;

    /**
     * 用户对应的邮箱地址
     */
    private String email;

    /**
     * 是否为管理员角色
     */
    private boolean isAdminRole;
}