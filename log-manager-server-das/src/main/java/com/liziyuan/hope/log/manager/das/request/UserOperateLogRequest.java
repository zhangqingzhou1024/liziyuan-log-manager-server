package com.liziyuan.hope.log.manager.das.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询参数
 *
 * @author zqz
 * @version 1.0
 * @date 2021-03-01 18:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserOperateLogRequest {
    /**
     * 用户账号
     */
    private String userAccount;
    /**
     * 系统模块,多个之间用逗号隔开
     */
    private String sysModelTypes;

    /**
     * 操作类型,多个之间用逗号隔开
     */
    private String operateTypes;
    /**
     * 开始时间
     */
    private Long operateTimeStart;
    /**
     * 结束时间
     */
    private Long operateTimeEnd;

    /**
     * 操作对象,多个之间用逗号隔开
     */
    private String operateObjects;
    /**
     * 请求参数
     */
    private String requestParams;

    /**
     * 分页参数
     */
    private Integer pageNo;

    /**
     * 页数据大小
     */
    private Integer pageSize;
    /**
     * 排序字段
     * weight desc
     */
    private String orderBy;
}
