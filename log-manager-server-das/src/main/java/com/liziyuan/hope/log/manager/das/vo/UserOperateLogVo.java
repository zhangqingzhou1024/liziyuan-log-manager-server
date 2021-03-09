package com.liziyuan.hope.log.manager.das.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 日志操作-vo
 *
 * @author zqz
 * @version 1.0
 * @date 2021-03-01 17:48
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("操作日志VO")
public class UserOperateLogVo implements Serializable {
    @ApiModelProperty("数据Id")
    private Long id;

    @ApiModelProperty("操作用户Id,当前系统为空")
    private Long userId;

    @ApiModelProperty("操作用户账号")
    private String userAccount;

    @ApiModelProperty("操作用户名称")
    private String userName;

    @ApiModelProperty("系统模块Id")
    private Long sysModelId;

    @ApiModelProperty("系统模块类型")
    private String sysModelType;

    @ApiModelProperty("系统模块名称")
    private String sysModelName;

    @ApiModelProperty("操作时间")
    private Date operateTime;

    @ApiModelProperty("操作时间-format")
    private String operateTimeStr;

    @ApiModelProperty("操作类型Id")
    private Long operateTypeId;

    @ApiModelProperty("操作类型")
    private String operateType;

    @ApiModelProperty("操作类型名称")
    private String operateTypeName;

    @ApiModelProperty("对象")
    private String operateObject;

    @ApiModelProperty("请求URL")
    private String requestUrl;

    @ApiModelProperty("请求类型")
    private String requestType;

    @ApiModelProperty("请求方法的全路径")
    private String requestMethod;

    @ApiModelProperty("请求参数")
    private String requestParams;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("入库时间")
    private Date insertTime;
    @ApiModelProperty("入库时间-format")
    private String insertTimeStr;

}
