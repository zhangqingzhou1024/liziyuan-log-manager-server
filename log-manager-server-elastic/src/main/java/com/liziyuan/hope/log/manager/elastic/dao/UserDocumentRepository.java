package com.liziyuan.hope.log.manager.elastic.dao;

import com.liziyuan.hope.log.manager.elastic.UserDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDocumentRepository extends ElasticsearchRepository<UserDocument, Integer> {
}
