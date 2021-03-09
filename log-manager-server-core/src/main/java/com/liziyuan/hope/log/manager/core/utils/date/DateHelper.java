package com.liziyuan.hope.log.manager.core.utils.date;


import com.liziyuan.hope.log.manager.core.constant.StringConst;
import org.apache.commons.lang3.time.DateUtils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * 时间工具类
 * 用JDK8来实现，线程安全
 * <p>
 * LocalDate：表示与时区无关的日期，与LocalDateTime相比，只有日期信息，没有时间信息
 * LocalDateTime: 表示与时区无关的日期和时间信息，不直接对应时刻，需要通过时区转换
 * LocalTime：表示与时区无关的时间，与LocalDateTime相比，只有时间信息，没有日期信息
 * Instant：它代表的是时间戳，表示时刻，不直接对应年月日信息，需要通过时区转换
 * ZonedDateTime： 表示特定时区的日期和时间
 * ZoneId/ZoneOffset：表示时区
 *
 * @author zqz
 * @version V1.0
 * @date 2020-04-05 20:53
 */
public class DateHelper {
    /**
     * 获取当前时间，时间格式 yyyy-MM-dd HH:mm:ss
     *
     * @return 获取当前时间
     */
    public static String getCurrentTime() {
        // 默认设置格式：yyyy-MM-dd HH:mm:ss
        return DateHelper.getCurrentTimeByPattern(DateFormatPattern.DATE_TIME_FORMAT.getPattern());
    }

    /**
     * 获取当前时间，时间格式 yyyy-MM-dd HH:mm:ss
     *
     * @return 获取当前时间
     */
    public static Date getCurrentDate() {
        // 默认设置格式：yyyy-MM-dd HH:mm:ss
        String currentTimeByPattern = DateHelper.getCurrentTimeByPattern(DateFormatPattern.DATE_TIME_FORMAT.getPattern());
        return dateParse(currentTimeByPattern);
    }

    /**
     * 获取当前时间，pattern 为时间格式
     *
     * @param pattern 时间转化格式
     * @return 获取当前时间
     */
    public static String getCurrentTimeByPattern(String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTimeFormat(localDateTime, pattern);
    }


    /**
     * 在当前时间的基础上，进行天数想加减
     *
     * @param days 相差的天数
     * @return 计算后的LocalDateTime
     */
    public static LocalDateTime plusDaysBaseNow(long days) {
        LocalDateTime now = LocalDateTime.now();
        return now.plusDays(days);
    }


    /**
     * 在当前时间的基础上，进行小时数相加减
     *
     * @param hours 相差的分钟数
     * @return 计算后的LocalDateTime
     */
    public static LocalDateTime plusHours(LocalDateTime localDateTime, long hours) {
        if (null == localDateTime) {
            localDateTime = LocalDateTime.now();
        }
        return localDateTime.plusHours(hours);
    }


    /**
     * 在当前时间的基础上，进行分钟数想加减
     *
     * @param minutes 相差的分钟数
     * @return 计算后的LocalDateTime
     */
    public static LocalDateTime plusMinutes(LocalDateTime localDateTime, long minutes) {
        if (null == localDateTime) {
            localDateTime = LocalDateTime.now();
        }
        return localDateTime.plusMinutes(minutes);
    }

    /**
     * 在当前时间的基础上，进行秒数想加减
     *
     * @param seconds 相差的秒数
     * @return 计算后的LocalDateTime
     */
    public static LocalDateTime plusSeconds(LocalDateTime localDateTime, long seconds) {
        if (null == localDateTime) {
            localDateTime = LocalDateTime.now();
        }
        return localDateTime.plusSeconds(seconds);
    }


    /**
     * 根据时间，获取当月的起始时间
     *
     * @param localDate 时间
     * @return 当月的起始时间
     */
    public static LocalDate getFirstDayOfMonth(LocalDate localDate) {

        return localDate.with(TemporalAdjusters.firstDayOfMonth());
    }


    /**
     * 根据时间，获取当月的结束时间时间
     *
     * @param localDate 时间
     * @return 当月的结束时间
     */
    public static LocalDate getLastDayOfMonth(LocalDate localDate) {

        return localDate.with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     * 获取某月的 最大的天数
     *
     * @param year     年份
     * @param monthVal 月份
     * @return 包含的天数
     */
    public static int getLengthOfMonth(int year, int monthVal) {
        LocalDate targetMonth = LocalDate.of(year, monthVal, 1);

        // 天的长度
        return targetMonth.lengthOfMonth();
    }

    /**
     * 获取当前年对应某月的最大的天数
     *
     * @param monthVal 月份
     * @return 包含的天数
     */
    public static int getLengthOfMonth(int monthVal) {
        // 天的长度
        return getLengthOfMonth(LocalDate.now().getYear(), monthVal);
    }


    /**
     * 计算两段时间的间隔 时间间隔为天，允许出现负数
     *
     * @param lowerTime  较早的时间
     * @param higherTime 较晚的时间
     * @return 时间间隔，单位天
     */
    public static BigDecimal calculateTimeBetween(Date lowerTime, Date higherTime) {
        if (lowerTime == null || higherTime == null) {
            return null;
        }
        long lowerCurr = lowerTime.getTime();
        long higherCurr = higherTime.getTime();
        long timeBetweenCurr = higherCurr - lowerCurr;


        return BigDecimal.valueOf(timeBetweenCurr).divide(BigDecimal.valueOf(DateUtils.MILLIS_PER_DAY), 2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 时间差，单位为月
     *
     * @param lowerTime  lowerTime
     * @param higherTime higherTime
     * @return 时间差，单位为月
     */
    public static int calculateMonthBetween(LocalDateTime lowerTime, LocalDateTime higherTime) {
        int lowerTimeYear = lowerTime.getYear();
        int lowerMonthValue = lowerTime.getMonthValue();
        int higherTimeYear = higherTime.getYear();
        int higherTimeMonthValue = higherTime.getMonthValue();

        int yearGap = higherTimeYear - lowerTimeYear;
        int monthGap = higherTimeMonthValue - lowerMonthValue;
        return yearGap * 12 + monthGap;
    }

    /**
     * 获取当前时间所在的月份
     * the month-of-year, from 1 to 12
     *
     * @param date date对象
     * @return 月份值
     */
    public static Integer getMonthNum(Date date) {
        if (null == date) {
            throw new NullPointerException("解析的日期参数不可为空！");
        }
        return dateToLocalDate(date).getMonthValue();
    }

    /**
     * 获取getDayOfMonth
     *
     * @param date date对象
     * @return 日期值
     */
    public static Integer getDayOfMonth(Date date) {
        if (null == date) {
            throw new NullPointerException("解析的日期参数不可为空！");
        }
        return dateToLocalDate(date).getDayOfMonth();
    }

    /**
     * 将date转换成String
     *
     * @param date Date对象
     * @return string 类型的时间
     */
    public static String dateFormat(Date date) {
        return dateFormat(date, DateFormatPattern.DATE_TIME_FORMAT.getPattern());
    }

    /**
     * 将date转换成String
     *
     * @param date    Date对象
     * @param pattern 解析模式
     * @return string 类型的时间
     */
    public static String dateFormat(Date date, String pattern) {
        return localDateTimeFormat(dateToLocalDateTime(date), pattern);
    }

    /**
     * 将localDate 按照一定的格式转换成String
     *
     * @param localDate LocalDate对象
     * @param pattern   解析模式
     * @return string 类型的时间
     */
    public static String localDateFormat(LocalDate localDate, String pattern) {
        return localDate.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将localDateTime 按照一定的格式转换成String
     *
     * @param localDateTime localDateTime
     * @param pattern       解析模式
     * @return string 类型的时间
     */
    public static String localDateTimeFormat(LocalDateTime localDateTime, String pattern) {
        if (null == pattern) {
            pattern = DateFormatPattern.DATE_TIME_FORMAT.getPattern();
        }
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 从字符型转化到 date
     *
     * @param time 字符型时间 yyyy-MM-dd HH:mm:ss 格式
     * @return date 类型
     */
    public static Date dateParse(String time) {
        LocalDateTime localDateTime = localDateTimeParse(time, DateFormatPattern.DATE_TIME_FORMAT.getPattern());
        return localDateTimeToDate(localDateTime);
    }

    /**
     * 从字符型转化到 date
     *
     * @param time    字符型时间
     * @param pattern 格式化形式
     * @return date 类型
     */
    public static Date dateParse(String time, String pattern) {
        LocalDateTime localDateTime = localDateTimeParse(time, pattern);
        return localDateTimeToDate(localDateTime);
    }

    /**
     * 将String 按照pattern 转换成
     *
     * @param time    string 类型的时间
     * @param pattern 解析模式
     * @return LocalDate
     */
    public static LocalDate localDateParse(String time, String pattern) {
        return LocalDate.parse(time, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将String 按照pattern 转换成LocalDateTime
     *
     * @param time    string 类型的时间
     * @param pattern 解析模式
     * @return LocalDateTime
     */
    public static LocalDateTime localDateTimeParse(String time, String pattern) {
        return LocalDateTime.parse(time, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将LocalDate 转换成 Date
     *
     * @param localDate LocalDate对象
     * @return LocalDate 转换成 Date
     */
    public static Date localDateToDate(LocalDate localDate) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        return Date.from(zdt.toInstant());
    }

    /**
     * 将LocalDateTime 转换成 Date
     *
     * @param localDateTime LocalDateTime对象
     * @return Date对象
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return localDateTimeToDate(localDateTime, ZoneId.systemDefault());
    }

    /**
     * 将LocalDateTime 转换成 Date
     *
     * @param localDateTime LocalDateTime对象
     * @return Date对象
     */
    public static Date localDateTimeToGMT8(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.of(StringConst.TIMEZONE_SHANGHAI);
        return localDateTimeToDate(localDateTime, zoneId);
    }

    /**
     * 将LocalDateTime 转换成 Date
     *
     * @param localDateTime LocalDateTime对象
     * @param zoneId        时区
     * @return Date对象
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime, ZoneId zoneId) {
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    /**
     * 从 long to LocalDateTime
     * 时区默认为 东8区
     *
     * @param timestamp 时间戳
     * @return LocalDateTime
     */
    public static LocalDateTime parseTimestamp(long timestamp) {
        return LocalDateTime.ofInstant(new Timestamp(timestamp).toInstant(), ZoneId.of(StringConst.TIMEZONE_SHANGHAI));
    }

    /**
     * 从 long to LocalDateTime
     *
     * @param timestamp 时间戳
     * @param zoneId    时区参数
     * @return LocalDateTime
     */
    public static LocalDateTime parseTimestamp(long timestamp, ZoneId zoneId) {
        return LocalDateTime.ofInstant(new Timestamp(timestamp).toInstant(), zoneId);
    }

    /**
     * 从 localDateTime to 时间戳
     *
     * @param localDateTime localDateTime
     * @return 时间戳
     */
    public static long getTimestamp(LocalDateTime localDateTime) {
        return Timestamp.valueOf(localDateTime).getTime();
    }

    /**
     * 一个月的开始时间
     *
     * @param localDateTime localDateTime
     * @return 一个月的开始时间
     */
    public static LocalDateTime getMonthStartTime(LocalDateTime localDateTime) {
        int dayOfMonth = localDateTime.getDayOfMonth();
        int hour = localDateTime.getHour();
        int minute = localDateTime.getMinute();
        int second = localDateTime.getSecond();
        int nano = localDateTime.getNano();
        return localDateTime.plusDays(-dayOfMonth + 1).plusHours(-hour).plusMinutes(-minute).plusSeconds(-second).plusNanos(-nano);
    }


    /**
     * 将 Date 转换成LocalDate
     * atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
     *
     * @param date date对象
     * @return Date 转换成LocalDate
     */
    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDate();
    }

    /**
     * 将 Date 转换成LocalDateTime
     * atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
     *
     * @param date date对象
     * @return Date 转换成LocalDateTime
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }

}
