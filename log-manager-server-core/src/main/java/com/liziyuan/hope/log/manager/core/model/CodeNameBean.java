package com.liziyuan.hope.log.manager.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 枚举类对外展示实体
 *
 * @author zqz
 * @version 1.0
 * @date 2021-03-02 15:36
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CodeNameBean {
    /**
     * 编码
     */
    private String code;
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String description;
}
