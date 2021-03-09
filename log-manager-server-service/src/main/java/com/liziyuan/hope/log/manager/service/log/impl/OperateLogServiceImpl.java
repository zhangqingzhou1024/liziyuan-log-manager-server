package com.liziyuan.hope.log.manager.service.log.impl;

import com.liziyuan.hope.log.manager.core.enums.SysModelTypeEnum;
import com.liziyuan.hope.log.manager.core.model.UserInfo;
import com.liziyuan.hope.log.manager.core.page.PageRequest;
import com.liziyuan.hope.log.manager.core.utils.user.UserUtils;
import com.liziyuan.hope.log.manager.das.vo.UserOperateLogVo;
import com.liziyuan.hope.log.manager.core.constant.NumberConst;
import com.liziyuan.hope.log.manager.core.constant.StringConst;
import com.liziyuan.hope.log.manager.core.enums.OperateTypeEnum;
import com.liziyuan.hope.log.manager.core.page.PageImpl;
import com.liziyuan.hope.log.manager.core.page.PageResult;
import com.liziyuan.hope.log.manager.core.page.Sort;
import com.liziyuan.hope.log.manager.core.utils.FieldValueUtils;
import com.liziyuan.hope.log.manager.core.utils.date.DateHelper;
import com.liziyuan.hope.log.manager.das.entity.UserOperateLog;
import com.liziyuan.hope.log.manager.das.entity.UserOperateLogPageExample;
import com.liziyuan.hope.log.manager.das.mapper.UserOperateLogMapper;
import com.liziyuan.hope.log.manager.das.request.UserOperateLogRequest;
import com.liziyuan.hope.log.manager.das.utils.ModelMapperUtils;
import com.liziyuan.hope.log.manager.service.log.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 操作日志-service impl
 *
 * @author zqz
 * @version 1.0
 * @date 2021-03-01 18:59
 */
@Service
public class OperateLogServiceImpl implements OperateLogService {
    @Autowired
    UserOperateLogMapper operateLogMapper;

    @Override
    public PageResult queryOperateLogByPage(UserOperateLogRequest logRequest) {
        // 构造查询条件
        UserOperateLogPageExample pageExample = buildOperateLogPageExample(logRequest);
        PageRequest pageRequest;
        // 构造排序条件
        if (FieldValueUtils.isNullType(logRequest.getOrderBy())) {
            Sort.Direction direction = Sort.Direction.valueOf(StringConst.DEF_SORT_TYPE);
            Sort orders = new Sort(direction, StringConst.DEF_SORT_FIELD);
            pageExample.setOrderByClause(StringConst.DEF_SORT_FIELD + " " + StringConst.DEF_SORT_TYPE);
            pageRequest = new PageRequest(logRequest.getPageNo(), logRequest.getPageSize(), orders);
        } else {
            String[] orderByArr = logRequest.getOrderBy().trim().split(" ");
            Sort.Direction direction = Sort.Direction.valueOf(orderByArr[1].toUpperCase());
            Sort orders = new Sort(direction, orderByArr[0]);
            pageExample.setOrderByClause(logRequest.getOrderBy());
            pageRequest = new PageRequest(logRequest.getPageNo(), logRequest.getPageSize(), orders);
        }

        long countNum = operateLogMapper.countByPageExample(pageExample);
        if (countNum < NumberConst.ONE) {
            PageImpl<UserOperateLogVo> operateLogVoPage = new PageImpl<>(Collections.emptyList(), pageRequest, countNum);
            return ModelMapperUtils.map(operateLogVoPage, PageResult.class);
        }

        List<UserOperateLog> userOperateLogs = operateLogMapper.selectByPage(pageExample);
        List<UserOperateLogVo> userOperateLogVos = ModelMapperUtils.mapList(userOperateLogs, UserOperateLogVo.class);
        fullLogOperateInfo(userOperateLogVos);

        PageImpl<UserOperateLogVo> operateLogVoPage = new PageImpl<>(userOperateLogVos, pageRequest, countNum);
        return ModelMapperUtils.map(operateLogVoPage, PageResult.class);
    }


    /**
     * 构建查询条件
     *
     * @param logRequest 请求参数
     * @return 查询条件
     */
    private UserOperateLogPageExample buildOperateLogPageExample(UserOperateLogRequest logRequest) {
        Integer pageNo = logRequest.getPageNo();
        Integer pageSize = logRequest.getPageSize();
        String operateObjects = logRequest.getOperateObjects();
        Long operateTimeStart = logRequest.getOperateTimeStart();
        Long operateTimeEnd = logRequest.getOperateTimeEnd();
        String operateTypes = logRequest.getOperateTypes();
        String sysModelTypes = logRequest.getSysModelTypes();
        String requestParams = logRequest.getRequestParams();
        String userAccount = logRequest.getUserAccount();
        if (FieldValueUtils.isNullType(pageNo) || pageNo < NumberConst.ONE) {
            pageNo = NumberConst.ONE;
            logRequest.setPageNo(pageNo);
        }
        if (FieldValueUtils.isNullType(pageSize)) {
            pageSize = NumberConst.TEN;
            logRequest.setPageSize(pageSize);
        }

        UserOperateLogPageExample pageExample = new UserOperateLogPageExample();
        pageExample.setStartIndex((pageNo - 1) * pageSize);
        pageExample.setPageSize(pageSize);
        UserOperateLogPageExample.Criteria criteria = pageExample.createCriteria();

        // 用户访问权限
        UserInfo userInfo = UserUtils.getUserInfo();
        if (!FieldValueUtils.isNullType(userInfo) && !FieldValueUtils.isNullType(userInfo.getAccount())) {
            // 普通用户只能查看自己的
            if (!userInfo.isAdminRole()) {
                criteria.andUserAccountEqualTo(userInfo.getAccount());
            } else {
                if (!FieldValueUtils.isNullType(userAccount)) {
                    criteria.andUserAccountLike("%" + userAccount + "%");
                }
            }
        }


        // 对象
        if (!FieldValueUtils.isNullType(operateObjects)) {
            criteria.andOperateObjectLike("%" + operateObjects + "%");
        }
        // 请求参数
        if (!FieldValueUtils.isNullType(requestParams)) {
            criteria.andRequestParamsLike("%" + requestParams + "%");
        }

        // 操作时间
        if (null != operateTimeStart) {
            criteria.andOperateTimeGreaterThanOrEqualTo(DateHelper.localDateTimeToDate(DateHelper.parseTimestamp(operateTimeStart)));
        }
        if (null != operateTimeEnd) {
            criteria.andOperateTimeLessThanOrEqualTo(DateHelper.localDateTimeToDate(DateHelper.parseTimestamp(operateTimeEnd)));
        }

        // 操作类型
        if (!FieldValueUtils.isNullType(operateTypes)) {
            List<OperateTypeEnum> operateTypeList = OperateTypeEnum.getOperateTypeList(operateTypes);
            if (!FieldValueUtils.isNullType(operateTypeList)) {
                List<Long> operateTypeIdList = operateTypeList.stream().map(OperateTypeEnum::getId).collect(Collectors.toList());
                criteria.andOperateTypeIdIn(operateTypeIdList);
            }
        }
        // 系统模块
        if (!FieldValueUtils.isNullType(sysModelTypes)) {
            List<SysModelTypeEnum> modelTypeList = SysModelTypeEnum.getModelTypeList(sysModelTypes);
            if (!FieldValueUtils.isNullType(modelTypeList)) {
                List<Long> modelIdList = modelTypeList.stream().map(SysModelTypeEnum::getId).collect(Collectors.toList());
                criteria.andSysModelIdIn(modelIdList);
            }
        }
        return pageExample;
    }

    /**
     * 补充参数信息
     *
     * @param userOperateLogVos 原始结果
     */
    private void fullLogOperateInfo(List<UserOperateLogVo> userOperateLogVos) {
        if (FieldValueUtils.isNullType(userOperateLogVos)) {
            return;
        }
        for (UserOperateLogVo operateLogVo : userOperateLogVos) {
            Date insertTime = operateLogVo.getInsertTime();
            Date operateTime = operateLogVo.getOperateTime();
            String operateType = operateLogVo.getOperateType();
            String sysModelType = operateLogVo.getSysModelType();
            if (!FieldValueUtils.isNullType(insertTime)) {
                operateLogVo.setInsertTimeStr(DateHelper.dateFormat(insertTime));
            }
            if (!FieldValueUtils.isNullType(operateTime)) {
                operateLogVo.setOperateTimeStr(DateHelper.dateFormat(operateTime));
            }
            OperateTypeEnum operateTypeEnum = OperateTypeEnum.getOperateType(operateType);
            if (null != operateTypeEnum) {
                operateLogVo.setOperateTypeName(operateTypeEnum.getOperateTypeName());
            }
            SysModelTypeEnum sysModelTypeEnum = SysModelTypeEnum.getModelType(sysModelType);
            if (null != sysModelTypeEnum) {
                operateLogVo.setSysModelName(sysModelTypeEnum.getModelName());
            }

        }
    }

}
