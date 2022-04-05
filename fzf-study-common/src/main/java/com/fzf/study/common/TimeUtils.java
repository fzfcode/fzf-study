package com.fzf.study.common;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * @author: SunKe
 * @date: 2020/9/11 10:33 上午
 * @description: 时间工具类
 */
public class TimeUtils {

    private TimeUtils() {
        // utility class
    }

    /**
     * 日期格式：yyyy-MM-dd HH:mm:ss
     */
    private static final String DEFAULT_FORMATTER = "yyyy-MM-dd HH:mm:ss";

    /**
     * 判断inputTime是否在startTime与endTime之间
     * @param inputTime 待校验时间
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 判断结果
     */
    public static boolean isBetween(Date inputTime, Date startTime, Date endTime) {
        if (!NullCheckUtils.checkIsAllNotNull(inputTime, startTime, endTime)) {
            throw new IllegalArgumentException("input time has null value");
        }

        return inputTime.after(startTime) && inputTime.before(endTime);
    }

    /**
     * LocalDate -> Date
     *
     * 以当前系统默认时区进行转换，默认时间为 00:00:00
     */
    public static Date from(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Date -> LocalDate
     *
     * 以当前系统默认时区进行转换，默认时间为 00:00:00
     */
    public static LocalDate to(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * LocalDateTime -> Date
     *
     * 以当前系统默认时区进行转换，默认时间为 00:00:00
     */
    public static Date from(LocalDateTime dateTime) {
        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Date -> LocalDate
     *
     * 以当前系统默认时区进行转换，默认时间为 00:00:00
     */
    public static LocalDateTime toLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }


    /**
     * 格式化时间
     * 默认格式：{@link #DEFAULT_FORMATTER}
     *
     * @param date      时间
     * @return  返回格式化后的字符串
     */
    public static String format(Date date) {
        return format(date, DEFAULT_FORMATTER);
    }

    /**
     * 格式化时间
     *
     * @param date      时间
     * @param format    待转化的格式
     * @return  返回格式化后的字符串
     */
    public static String format(Date date, String format) {
        if (date == null || StringUtils.isEmpty(format)) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return toLocalDateTime(date).format(formatter);
    }

    /**
     * 解析时间
     * 默认格式：{@link #DEFAULT_FORMATTER}
     *
     * @param date      时间字符串
     * @return  返回对应的时间
     */
    public static Date parse(String date) {
        return parse(date, DEFAULT_FORMATTER);
    }

    /**
     * 时间解析
     *
     * @param dateStr   时间字符串
     * @param format    待解析的格式
     * @return  返回对应的时间
     */
    public static Date parse(String dateStr, String format) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            throw new IllegalArgumentException("时间解析异常，date: " + dateStr + ", format: " + format, e);
        }
    }

    /**
     * 获取当前时间
     *
     */
    public static Date now() {
        return Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取每月第一天
     *
     * 如: 2018-03-01
     */
    public static LocalDate firstDayOfMonth() {
        return LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 获取每月最后一天
     *
     * 如: 2018-03-31
     */
    public static LocalDate lastDayOfMonth() {
        return LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     * 获取当前日期以后N天日期
     *
     * 如：2018-08-07，3天后日期为 2018-08-10
     */
    public static Date plusDays(int days) {
        return from(LocalDate.now().plusDays(days));
    }

    /**
     * 获取指定日期以后N天日期
     *
     * 如：2018-08-07，3天后日期为 2018-08-10
     */
    public static Date plusDays(Date date, int days) {
        return from(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusDays(days));
    }

    /**
     * 获取指定日期以后N月
     *
     * 如：2018-08-07，3天后日期为 2018-11-07
     */
    public static Date plusMonths(Date date, int months) {
        return from(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusMonths(months));
    }

    /**
     * 获取当前日期之前N天日期
     *
     * 如：2018-08-07，3天后日期为 2018-08-10
     */
    public static Date minusDays(int days) {
        return from(LocalDate.now().minusDays(days));
    }

    /**
     * 获取指定日期之前N天日期
     *
     * 如：2018-08-07，3天前日期为 2018-08-04
     */
    public static Date minusDays(Date date, int days) {
        return from(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().minusDays(days));
    }

    /**
     * 判断两个时间区间是否有交集
     */
    public static boolean hasTimeIntersection(Date startTime1, Date endTime1, Date startTime2, Date endTime2) {
        if (!NullCheckUtils.checkIsAllNotNull(startTime1, endTime1, startTime2, endTime2)) {
            throw new IllegalArgumentException("input time has null value");
        }

        return (isBetween(startTime1, startTime2, endTime2) || startTime1.equals(startTime2)) ||
                (isBetween(endTime1, startTime2, endTime2) || endTime1.equals(endTime2));
    }


}
