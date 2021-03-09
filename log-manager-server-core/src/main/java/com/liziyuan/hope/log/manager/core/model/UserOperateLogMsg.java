package com.liziyuan.hope.log.manager.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户操作日志
 * @author zqz
 * @version 1.0
 * @date 2021-02-23 20:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserOperateLogMsg implements Serializable {
    private Long id;
    private Long userId;
    private String userAccount;
    private String userName;
    private Long sysModelId;
    private String sysModelType;
    private Date operateTime;
    private String operateTimeStr;
    private String operateType;
    private Long operateTypeId;
    private String operateObject;
    private String requestParams;
    private String requestUrl;
    private String requestType;
    private String requestMethod;
    private String remark;
}
