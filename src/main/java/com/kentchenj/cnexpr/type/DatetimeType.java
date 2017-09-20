package com.kentchenj.cnexpr.type;

/**
 * 时间类型
 * @author Kent Chen
 */
public class DatetimeType extends DateType{
  private String formatter = "yyyy/MM/dd hh:mm:ss";

  @Override
  public String getFormatter() {
    return formatter;
  }

  @Override
  public void setFormatter(String formatter) {
    this.formatter = formatter;
  }
}
