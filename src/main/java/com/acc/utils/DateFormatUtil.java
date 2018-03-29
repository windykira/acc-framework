package com.acc.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式化工具类。
 * @author maxl。
 */
public class DateFormatUtil {

    private static SimpleDateFormat defaultFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getFormatDate(Date date){
        return defaultFormat.format(date);
    }
}
