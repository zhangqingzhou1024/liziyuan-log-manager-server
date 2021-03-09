package com.liziyuan.hope.log.manager.core.utils;

import com.alibaba.fastjson.JSON;
import com.liziyuan.hope.log.manager.core.model.UserOperateLogMsg;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * 日志工具类
 *
 * @author zqz
 * @version 1.0
 * @date 2021-02-23 20:23
 */
public class LoggerUtils {

    /**
     * 分隔符
     */
    private static String newLine = System.getProperty("line.separator", "\n");

    /**
     * @param fileName       文件地址
     * @param userOperateLog 日志内容
     */
    public static void writeUserOperateLog(String fileName, UserOperateLogMsg userOperateLog) {
        try {
            String userOperateLogStr = JSON.toJSONString(userOperateLog);
            File file = new File(fileName);
            FileUtils.writeStringToFile(file, userOperateLogStr + newLine, StandardCharsets.UTF_8, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回文件全路径
     *
     * @param fileName 文件名
     * @return 返回文件全路径
     */
    public static String createFileIfNotExistsFile(String dirPath, String fileName) {
        File logFile = new File(fileName);
        if (!logFile.exists()) {
            try {
                File dirFile = new File(dirPath);
                boolean isMkdirs = dirFile.mkdirs();
                if (isMkdirs) {
                    System.out.println(">>>>>>>> 创建目录：" + dirFile.getAbsolutePath());
                }

                boolean isCreated = logFile.createNewFile();
                if (isCreated) {
                    System.out.println(">>>>>>>> 创建文件：" + logFile.getAbsolutePath());
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return logFile.getAbsolutePath();
    }


}

