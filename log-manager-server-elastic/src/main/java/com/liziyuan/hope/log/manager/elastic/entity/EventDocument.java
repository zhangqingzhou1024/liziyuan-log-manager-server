package com.liziyuan.hope.log.manager.elastic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @autor zqz
 * @description
 * @date 2021/5/28
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "log-event",type = "doc",shards = 3, replicas = 0)
public class EventDocument {
    @Id
    private int id;
    @Field(type = FieldType.Integer)
    private int userId;
    @Field(type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_smart_word")
    private String title;
    @Field(type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_smart_word")
    private String content;
    @Field(type = FieldType.Integer)
    private int type;
    @Field(type = FieldType.Date)
    private Date insertTime;
}

