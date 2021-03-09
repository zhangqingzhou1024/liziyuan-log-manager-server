package com.liziyuan.hope.log.manager.core.constant;

/**
 * 字符串常量
 *
 * @author zqz
 * @version 1.0
 * @date 2020-04-09 21:32
 */
public class StringConst {

    /**
     * 空字符串
     */
    public static final String DEFAULT_STRING = "";

    /**
     * 小数点
     */
    public static final String RADIX_POINT = ".";

    /**
     * 逗号
     */
    public static final String COMMA_POINT = ",";

    /**
     * 中横线
     */
    public static final String SHORT_LINE = "-";

    /**
     * @
     */
    public static final String EMAIL_CHAR = "@";

    /**
     * #
     */
    public static final String API_MAPPING_SPIL_CHAR = "#";

    /**
     * "null"
     */
    public static final String NULL_STRING = "null";

    /**
     * "true"
     */
    public static final String TRUE_STRING = "true";

    /**
     * Asia/Shanghai
     * 东8区
     */
    public static final String TIMEZONE_SHANGHAI = "Asia/Shanghai";

    /**
     * UTC
     */
    public static final String TIMEZONE_UTC = "UTC";

    /**
     * login-system
     */
    public static final String LOGIN_SYSTEM_TYPE = "login-system";

    /**
     * aecore
     */
    public static final String AECORE_LOGIN_TYPE = "aecore";

    /**
     * datahub
     */
    public static final String DATAHUB_LOGIN_TYPE = "datahub";


    /**
     * 默认排序参数
     */
    public final static String DEF_SORT_FIELD = "insert_time";
    public final static String DEF_SORT_TYPE = "DESC";


    /**
     * 系统模块名称- key
     */
    public static final String SYS_MODEL_NAME_KEY = "defSysModelName";
    /**
     * 用户操作日志默认地址 - key
     */
    public static final String USER_OPERATE_LOG_PATH_KEY = "userOperateLogPath";
    /**
     * 用户操作日志是否输出 - key
     */
    public static final String OPERATE_LOG_SYSTEM_OUT_KEY = "operateLogSystemOut";

    /**
     * 用户操作日志默认地址
     */
    public static final String DEF_USER_OPERATE_LOG_PATH = "../user-operate-logs/";


    /**
     * 用户操作日志默认地址
     */
    public static final String USER_OPERATE_LOG_FILE_PREFIX = "sys_user_operate";

    /**
     * 用户操作日志 output kafka topic
     * kafkalogstash
     * liziyuan-sys-log-logstash-topic
     */
    public static final String SYS_USER_OPERATE_LOG_TOPIC = "liziyuan-sys-log-logstash-topic";

    /**
     * 日志消息体，真是message的key
     */
    public static final String LOG_KAFKA_MESSAGE_KEY = "message";

}
