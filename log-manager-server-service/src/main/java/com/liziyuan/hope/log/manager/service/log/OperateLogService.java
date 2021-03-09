package com.liziyuan.hope.log.manager.service.log;

import com.liziyuan.hope.log.manager.core.page.PageResult;
import com.liziyuan.hope.log.manager.das.request.UserOperateLogRequest;
import com.liziyuan.hope.log.manager.das.vo.UserOperateLogVo;

/**
 * 操作日志-service
 *
 * @author zqz
 * @version 1.0
 * @date 2021-03-01 17:47
 */
public interface OperateLogService {

    /**
     * 分页查询
     *
     * @param operateLogRequest 查询参数
     * @return 日志数据
     */
    PageResult<UserOperateLogVo> queryOperateLogByPage(UserOperateLogRequest operateLogRequest);
}
