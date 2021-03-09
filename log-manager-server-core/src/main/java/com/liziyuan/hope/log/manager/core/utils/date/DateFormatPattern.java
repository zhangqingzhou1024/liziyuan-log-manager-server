package com.liziyuan.hope.log.manager.core.utils.date;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 时间转化模式 枚举类型
 *
 * @author zqz
 * @version 1.0
 * @date 2020-04-05 21:53
 */
@Getter
@AllArgsConstructor
public enum DateFormatPattern {
    /**
     * yyyy-MM-dd
     */
    DATE_FORMAT("yyyy-MM-dd"),

    /**
     * yyyyMMdd
     */
    DATE_FORMAT_NO_SPLIT("yyyyMMdd"),

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    DATE_TIME_FORMAT("yyyy-MM-dd HH:mm:ss"),


    /**
     * yyyy-MM-dd HH
     */
    DATE_TIME_H_FORMAT("yyyy-MM-dd HH"),

    /**
     * yyyyMMddHH
     * 如：2020092911
     */
    DATE_TIME_SH_FORMAT("yyyyMMddHH"),

    /**
     * yyyy-MM-dd HH:mm:ss.SSS
     */
    DATE_TIME_MS_FORMAT("yyyy-MM-dd HH:mm:ss.SSS"),

    /**
     * yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
     */
    DATE_TIME_TS_FORMAT("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"),

    DATE_TIME_THIN_TS_FORMAT("MM/dd/yyyy HH:mm:ss Z"),

    /**
     * yyyyMMddHHmm
     */
    DATE_TIME_SHORT_FORMAT("yyyyMMddHHmm"),

    /**
     * MM/dd/yyyy HH:mm:ss
     */
    DATE_TIME_CST_FORMAT("MM/dd/yyyy HH:mm:ss");

    /**
     * 解析匹配模式
     */
    private String pattern;
}
