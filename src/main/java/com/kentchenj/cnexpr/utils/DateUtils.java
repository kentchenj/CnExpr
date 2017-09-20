package com.kentchenj.cnexpr.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.Date;

/**
 * 日期函数工具
 * @author Kent Chen
 */
public class DateUtils {
  /**
   * 字符串转JodaTime
   * @param str
   * @param formatter
   * @return
   */
  public static DateTime stringToJodaTime (String str, String formatter) {
    return DateTime.parse(str, DateTimeFormat.forPattern(formatter));
  }

  /**
   * Date转
   * @param date
   * @return
   */
  public static DateTime dateToJodaTime (Date date) {
    return new DateTime(date);
  }
}
