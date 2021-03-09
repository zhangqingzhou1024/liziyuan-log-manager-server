package com.liziyuan.hope.log.manager.collector.config;

import com.liziyuan.hope.log.manager.core.constant.StringConst;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 加载配置文件内容
 *
 * @author zqz
 * @version 1.0
 * @date 2021-02-24 20:49
 */
public class OperateLogPropertiesUtils {
    public static ConcurrentHashMap<String, String> propertiesMap = new ConcurrentHashMap<>(64);

    /**
     * 一些子系统参数
     */
    public static Long SYS_MODEL_ID = -1L;
    public static String SYS_MODEL_CODE = "";
    public static String SYS_MODEL_NAME = "";
    public static boolean OPERATE_LOG_SYSTEM_OUT = false;

    /**
     * 日志文件写入地址
     */
    public static String USER_OPERATE_LOG_PATH = StringConst.DEF_USER_OPERATE_LOG_PATH;

    /**
     * 加在文件
     *
     * @param props 配置文件
     * @throws Exception
     */
    private static void processProperties(Properties props) throws Exception {
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            try {
                propertiesMap.put(keyStr, new String(props.getProperty(keyStr).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 加在配置文件信息-支持多个
     *
     * @param propertyFileName 文件名称
     */
    public static void loadAllProperties(String propertyFileName) {
        try {
            Properties properties = PropertiesLoaderUtils.loadAllProperties(propertyFileName);
            processProperties(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取接口配置信息
     *
     * @param key key
     * @return 配置信息
     */
    public static String getProperty(String key) {
        return propertiesMap.get(key);
    }

    /**
     * 获取接口配置信息列表
     *
     * @return 配置信息列表
     */
    public static Map<String, String> getAllProperty() {
        return propertiesMap;
    }
}
