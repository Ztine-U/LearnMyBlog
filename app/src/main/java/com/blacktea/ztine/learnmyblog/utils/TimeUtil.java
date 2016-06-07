package com.blacktea.ztine.learnmyblog.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by ztine on 16/6/7.
 */
public class TimeUtil {
    /**
     * String转换为时间
     *
     * @param str
     * @return
     */
    public static Date ParseDate(String str) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date addTime = null;
        try {
            addTime = dateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return addTime;
    }

    /**
     * 将日期转换为字符串
     *
     * @param date
     * @return
     */
    public static String ParseDateToString(Date date) {
        return ParseDateToString(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 将日期转换为字符串（重载）
     *
     * @param date
     * @param format:时间格式，必须符合yyyy-MM-dd hh:mm:ss
     * @return
     */
    public static String ParseDateToString(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);

        return dateFormat.format(date);
    }

    /**
     * 将UMT时间转换为本地时间
     *
     * @param str
     * @return
     * @throws ParseException
     */
    public static Date ParseUTCDate(String str) {
        //格式化2012-03-04T23:42:00+08:00
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.CHINA);
        try {
            Date date = formatter.parse(str);

            return date;
        } catch (ParseException e) {
            //格式化Sat, 17 Mar 2012 11:37:13 +0000
            //Sat, 17 Mar 2012 22:13:41 +0800
            try {
                SimpleDateFormat formatter2 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.CHINA);
                Date date2 = formatter2.parse(str);

                return date2;
            } catch (ParseException ex) {
                return null;
            }
        }
    }

    /**
     * 将时间转换为中文
     *
     * @param datetime
     * @return
     */
    public static String DateToChineseString(Date datetime) {
        Date today = new Date();
        long seconds = (today.getTime() - datetime.getTime()) / 1000;

        long year = seconds / (24 * 60 * 60 * 30 * 12);// 相差年数
        long month = seconds / (24 * 60 * 60 * 30);//相差月数
        long date = seconds / (24 * 60 * 60);     //相差的天数
        long hour = (seconds - date * 24 * 60 * 60) / (60 * 60);//相差的小时数
        long minute = (seconds - date * 24 * 60 * 60 - hour * 60 * 60) / (60);//相差的分钟数
        long second = (seconds - date * 24 * 60 * 60 - hour * 60 * 60 - minute * 60);//相差的秒数

        if (year > 0) {
            return year + "年前";
        }
        if (month > 0) {
            return month + "月前";
        }
        if (date > 0) {
            return date + "天前";
        }
        if (hour > 0) {
            return hour + "小时前";
        }
        if (minute > 0) {
            return minute + "分钟前";
        }
        if (second > 0) {
            return second + "秒前";
        }
        return "未知时间";
    }
}