package com.liziyuan.hope.log.manager.elastic.dao;

import com.liziyuan.hope.log.manager.elastic.entity.EventDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventDocumentRepository extends ElasticsearchRepository<EventDocument, Integer> {
}
