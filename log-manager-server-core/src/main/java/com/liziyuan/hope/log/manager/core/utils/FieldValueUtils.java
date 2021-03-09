package com.liziyuan.hope.log.manager.core.utils;


import com.alibaba.fastjson.JSONArray;
import com.liziyuan.hope.log.manager.core.constant.NumberConst;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 一些常用方法util
 *
 * @author zqz
 * @version 1.0
 * @date 2020-04-14 21:55
 */
public class FieldValueUtils {
    /**
     * 特殊字符
     */
    private static final String SPECIAL_CHAR_REGEX = "^.*[(/)|(\\\\\\\\)|(:)|(\\\\*)|(\\\\?)|(\\\")|(<)|(>)].*$";

    /**
     * decimal + integer (-MAX, MAX)
     */
    private static final String REGEX_REAL_NUMBER = "^[-\\+]?(\\d+|\\d+\\.\\d+)$";

    /**
     * 检核类型
     */
    private static final String RANGE_CHECK_TYPE = "range";
    private static final String IN_CHECK_TYPE = "in";

    /**
     * 判断是否为空的形式
     *
     * @param object Object 对象
     * @return 是否为空
     */
    public static boolean isNullType(Object object) {
        if (null == object) {
            return true;
        }
        // 如果是字符串，要判断长度是否为空
        if (object instanceof String) {
            return ((String) object).trim().length() == 0;
        }
        if (object instanceof Map) {
            return CollectionUtils.isEmpty(((Map) object));
        }

        if (object instanceof List) {
            return CollectionUtils.isEmpty((List) object);
        }

        if (object instanceof Set) {
            return CollectionUtils.isEmpty(((Set) object));
        }

        return false;
    }

    /**
     * 判断全部参数是否为空
     *
     * @param object 可变参数Object
     * @return 是否为空
     */
    public static boolean isAllNull(Object... object) {
        if (isNullType(object)) {
            return true;
        }
        // 只要有一个非空即为false
        for (Object o : object) {
            if (!isNullType(o)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 判断至少有一个参数是否为空
     *
     * @param object 可变参数Object
     * @return 至少有一个参数是否为空
     */
    public static boolean isHaveNull(Object... object) {
        if (isNullType(object)) {
            return true;
        }

        // 有一个为空即为true
        for (Object o : object) {
            if (isNullType(o)) {
                return true;
            }
        }

        return false;
    }


    /**
     * 去除空格
     *
     * @param source 源字符串
     * @return 去除两侧空格后的字符串
     */
    public static String trim(String source) {
        if (StringUtils.isEmpty(source)) {
            return null;
        }
        String trim = source.trim();
        if (trim.length() == NumberConst.ZERO_INT) {
            return null;
        }
        return trim;
    }

    /**
     * 判断某个字符串是否超过某个长度
     *
     * @param source 源字符串
     * @param length 指定长度
     * @return 是否超过某个知道长度
     */
    public static boolean isOverSpecifiedLength(String source, int length) {
        if (length < 0) {
            throw new IllegalArgumentException("the String length must > 0, now set " + length);
        }
        if (isNullType(source)) {
            return false;
        }
        return source.trim().length() > length;
    }


    /**
     * 判断字符是否满足正则表达式
     *
     * @param source 源字符串
     * @param regex  正则表达式
     * @return 是否满足正则表达式
     */
    public static boolean isMatchRegex(String source, String regex) {
        return Pattern.matches(regex, source);
    }

    /**
     * 判断值是否满足正则表达式
     *
     * @param key         key
     * @param matchRexArr 正则数组
     * @return key 是否满足正则表达式
     */
    public static boolean isMatchKey(String key, String[] matchRexArr) {
        if (null == key || null == matchRexArr || matchRexArr.length == 0) {
            return false;
        }

        for (String matchRex : matchRexArr) {
            matchRex = matchRex.replaceAll("\"", "");
            if (key.equalsIgnoreCase(matchRex) || isMatchRegex(key, matchRex)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 是否为端口
     *
     * @param obj 端口值
     * @return 是否为端口
     */
    public static boolean isPortVal(Object obj) {
        if (FieldValueUtils.isNullType(obj)) {
            return false;
        }

        int port;
        try {
            port = Integer.parseInt(obj.toString().trim());
        } catch (Exception e) {
            return false;
        }

        // 端口范围
        return port >= 0 && port < NumberConst.MAX_PORT_NUM;
    }

    /**
     * 返回一个布尔值代表一个给定的Cron表达式的有效性
     *
     * @param cronExpression Cron表达式
     * @return boolean 表达式是否有效
     */
    public static boolean isValidCronExpression(String cronExpression) {
        if (isNullType(cronExpression)) {
            return false;
        }
        return CronSequenceGenerator.isValidExpression(cronExpression);
    }

    /**
     * 判断是否为数字
     *
     * @param str numStr
     * @return 判断是否为数字
     */
    public static boolean isNumeric(String str) {
        // 去除小数点
        str = str.replaceFirst("\\.", "");
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断是不是date 类型
     *
     * @param obj obj
     * @return 判断是不是date 类型
     */
    public static boolean isDateType(Object obj) {
        if (null == obj) {
            return false;
        }
        return obj instanceof Date;
    }

    /**
     * 判断是不是String 类型
     *
     * @param obj obj
     * @return 判断是不是String 类型
     */
    public static boolean isStrType(Object obj) {
        if (null == obj) {
            return false;
        }

        return obj instanceof String;
    }

    /**
     * 是否为普通字符
     *
     * @param str 字符
     * @return 是否为普通字符
     */
    public static boolean isCommonStr(String str) {
        if (isNullType(str)) {
            return false;
        }

        return !isMatchRegex(str, SPECIAL_CHAR_REGEX);
    }


    /**
     * 去除多个空格，只保留一个空格
     *
     * @param sourceStr 元字符
     * @return 去除多个空格，只保留一个空格
     */
    public static String removeMoreBlanks(String sourceStr) {
        if (isNullType(sourceStr)) {
            return null;
        }

        return sourceStr.replaceAll(" +", " ");
    }

    /**
     * 实数，包括所有的整数与小数 (-MAX, MAX)
     *
     * @param orginal 源字符
     * @return boolean
     */
    public static boolean isRealNumber(Object orginal) {
        if (FieldValueUtils.isNullType(orginal)) {
            return false;
        }

        boolean isMatch = isMatch(REGEX_REAL_NUMBER, orginal.toString());
        if (isMatch) {
            return true;
        }

        boolean isNum = NumberUtils.isCreatable(orginal.toString());
        if (isNum) {
            return true;
        }
        return orginal instanceof Float || orginal instanceof Double;
    }

    /**
     * 判断两个值是否相等
     *
     * @param obj1 值1
     * @param obj2 值2
     * @return 两个值是否相等
     */
    public static boolean isEquals(Object obj1, Object obj2) {
        // 全部为空
        if (isAllNull(obj1, obj2)) {
            return true;
        }

        // 存在为空
        if (isHaveNull(obj1, obj2)) {
            return false;
        }
        return obj1.equals(obj2);
    }

    /**
     * 实数，包括所有的整数与小数 (-MAX, MAX)
     *
     * @param orginal 源字符
     * @return boolean
     */
    private static boolean isRealNumber(String orginal) {
        return isMatch(REGEX_REAL_NUMBER, orginal);
    }

    private static boolean isMatch(String regex, String orginal) {
        if (StringUtils.isBlank(orginal)) {
            return false;
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher isNum = pattern.matcher(orginal);
        return isNum.matches();
    }

    /**
     * 转换成jsonArr
     *
     * @param jsonArrStr jsonArrStr
     * @return jsonArr
     */
    public static JSONArray parseJsonArr(String jsonArrStr) {
        return JSONArray.parseArray(jsonArrStr);
    }

    /**
     * 判断文本是否包含目标字符
     *
     * @param context 文本
     * @param keys    必须包含的关键字
     * @return true: 全都包含, false: 其他情况
     */
    public static boolean isContainsAll(String context, List<String> keys) {
        if (FieldValueUtils.isNullType(context)) {
            return false;
        }
        if (FieldValueUtils.isNullType(keys)) {
            return true;
        }

        for (String key : keys) {
            if (!isContainsKey(context, key)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断文本是否包含目标字符
     *
     * @param context 文本
     * @param keys    必须包含的关键字
     * @return true: 至少包含一个, false: 其他情况
     */
    public static boolean isContainsOne(String context, List<String> keys) {
        if (FieldValueUtils.isNullType(context)) {
            return false;
        }
        if (FieldValueUtils.isNullType(keys)) {
            return true;
        }

        for (String key : keys) {
            if (isContainsKey(context, key)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断文本不能包含目标字符
     *
     * @param context 文本
     * @param keys    必须包含的关键字
     * @return true: 全不包含, false: 其他情况
     */
    public static boolean isNotContainsEvery(String context, List<String> keys) {
        if (FieldValueUtils.isHaveNull(context, keys)) {
            return true;
        }

        for (String key : keys) {
            if (isContainsKey(context, key)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断文本是否包含目标字符
     *
     * @param context 文本
     * @param target  目标字符
     * @return 判断文本是否包含目标字符
     */
    public static boolean isContainsKey(String context, String target) {
        if (FieldValueUtils.isNullType(context)) {
            return false;
        }
        if (FieldValueUtils.isNullType(target)) {
            return true;
        }
        context = context.toLowerCase();
        target = target.toLowerCase();
        context = context.replaceAll(",", " ").replaceAll("\\(", " ").replaceAll(" +", " ");
        String[] keys = context.split(" ");
        for (String key : keys) {
            if (key.equals(target)) {
                return true;
            }
        }
        return false;
    }

}
