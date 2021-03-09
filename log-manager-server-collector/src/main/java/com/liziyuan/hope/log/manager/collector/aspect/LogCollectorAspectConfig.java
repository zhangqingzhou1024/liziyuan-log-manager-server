package com.liziyuan.hope.log.manager.collector.aspect;

/**
 * 日志拦截系统路径配置
 *
 * @author zqz
 * @version 1.0
 * @date 2021-03-04 17:33
 */
public class LogCollectorAspectConfig {

    /**
     * 数据质量 & 数据标准
     */
    public static final String DATA_QUALITY_SERVER_ASPECT_CONF = "execution(public * com.liziyuan.quality.web.controller..*.*(..))";

    /**
     * 数据集成
     */
    public static final String DATA_INTEGRATION_SERVICE_ASPECT_CONF = "execution(public * com.liziyuan.datapipe.resources.api..*.*(..))";

    /**
     * 数据资源、控制台、系统管理 com.liziyuan.catalog.domain.controller
     */
    public static final String DATAHUB_CATALOG_SERVER_ASPECT_CONF = "execution(public * com.liziyuan.catalog.api..*.*(..))";
}
