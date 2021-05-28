package com.liziyuan.hope.log.manager.elastic.service;

import com.liziyuan.hope.log.manager.elastic.entity.EventDocument;

/**
 * @author zqz
 * @version 1.0
 * @date 2021-05-28 10:34
 */
public interface EventDocService {
    /**
     * 保存数据
     *
     * @param eventDocument 数据信息
     * @return 数据香¬
     */
    EventDocument save(EventDocument eventDocument);
}
