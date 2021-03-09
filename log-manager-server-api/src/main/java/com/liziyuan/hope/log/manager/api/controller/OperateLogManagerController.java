package com.liziyuan.hope.log.manager.api.controller;

import com.liziyuan.hope.log.manager.core.model.CodeNameBean;
import com.liziyuan.hope.log.manager.das.vo.UserOperateLogVo;
import com.liziyuan.hope.log.manager.core.enums.OperateTypeEnum;
import com.liziyuan.hope.log.manager.core.enums.SysModelTypeEnum;
import com.liziyuan.hope.log.manager.core.page.PageResult;
import com.liziyuan.hope.log.manager.das.request.UserOperateLogRequest;
import com.liziyuan.hope.log.manager.service.log.OperateLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 日志管理controller
 *
 * @author zqz
 * @version 1.0
 * @date 2021-03-01 17:45
 */
@Api(tags = "日志管理相关接口")
@RestController
@RequestMapping("/operate-logs")
public class OperateLogManagerController {
    @Autowired
    OperateLogService operateLogService;

    @ApiOperation("分页查询用户操作日志")
    @GetMapping("/queryByPage")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "userAccount", value = "账号"),
            @ApiImplicitParam(name = "sysModelTypes", value = "系统模块类型，多个值用逗号隔开"),
            @ApiImplicitParam(name = "operateTypes", value = "操作类型，多个值用逗号隔开"),
            @ApiImplicitParam(name = "operateObjects", value = "对象"),
            @ApiImplicitParam(name = "requestParams", value = "请求参数"),
            @ApiImplicitParam(name = "operateTimeStart", value = "操作开始时间"),
            @ApiImplicitParam(name = "operateTimeEnd", value = "操作结束时间"),
            @ApiImplicitParam(name = "orderBy", value = "排序规则，如 insert_time DESC"),
            @ApiImplicitParam(name = "pageNo", value = "页码"),
            @ApiImplicitParam(name = "pageSize", value = "每页数据大小"),
    })
    public ResponseEntity<PageResult<UserOperateLogVo>> queryOperateLogByPage(String userAccount, String sysModelTypes, String operateTypes, String operateObjects, String requestParams, Long operateTimeStart, Long operateTimeEnd, String orderBy, Integer pageNo, Integer pageSize) {
        // 封装请求参数
        UserOperateLogRequest operateLogRequest = UserOperateLogRequest.builder().sysModelTypes(sysModelTypes).operateTypes(operateTypes)
                .operateObjects(operateObjects).requestParams(requestParams).operateTimeStart(operateTimeStart).operateTimeEnd(operateTimeEnd)
                .userAccount(userAccount).pageNo(pageNo).pageSize(pageSize).orderBy(orderBy).build();

        return new ResponseEntity<>(operateLogService.queryOperateLogByPage(operateLogRequest), HttpStatus.OK);
    }

    @ApiOperation("获取用户操作类型")
    @GetMapping("/operateTypes")
    public ResponseEntity<List<CodeNameBean>> getOperateTypeList() {
        OperateTypeEnum[] values = OperateTypeEnum.values();
        List<CodeNameBean> codeNameBeans = new ArrayList<>();
        for (OperateTypeEnum value : values) {
            boolean isShow = value.isShow();
            if (isShow) {
                codeNameBeans.add(CodeNameBean.builder().code(value.getOperateType()).name(value.getOperateTypeName()).build());
            }
        }
        return new ResponseEntity<>(codeNameBeans, HttpStatus.OK);
    }

    @ApiOperation("获取系统模块列表")
    @GetMapping("/sysModelTypes")
    public ResponseEntity<List<CodeNameBean>> getSysModelTypeEnumList() {
        SysModelTypeEnum[] values = SysModelTypeEnum.values();
        List<CodeNameBean> codeNameBeans = new ArrayList<>();
        for (SysModelTypeEnum value : values) {
            boolean isShow = value.isShow();
            if (isShow) {
                codeNameBeans.add(CodeNameBean.builder().code(value.getModelType()).name(value.getModelName()).build());
            }
        }
        return new ResponseEntity<>(codeNameBeans, HttpStatus.OK);
    }
}
