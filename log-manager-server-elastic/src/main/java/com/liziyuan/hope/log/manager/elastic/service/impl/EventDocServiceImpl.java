package com.liziyuan.hope.log.manager.elastic.service.impl;

import com.liziyuan.hope.log.manager.elastic.dao.EventDocumentRepository;
import com.liziyuan.hope.log.manager.elastic.entity.EventDocument;
import com.liziyuan.hope.log.manager.elastic.service.EventDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zqz
 * @version 1.0
 * @date 2021-05-28 10:35
 */
@Service("eventDocService")
public class EventDocServiceImpl implements EventDocService {
    @Autowired
    EventDocumentRepository eventDocumentRepository;

    @Override
    public EventDocument save(EventDocument eventDocument) {
        return eventDocumentRepository.save(eventDocument);
    }
}
