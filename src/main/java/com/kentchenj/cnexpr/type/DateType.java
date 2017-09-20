package com.kentchenj.cnexpr.type;

/**
 * 日期类型
 * @author Kent Chen
 *
 */
public class DateType extends Type{
  private String name = "date";
  private String formatter = "yyyy/MM/dd";
  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  public String getFormatter() {
    return formatter;
  }

  public void setFormatter(String formatter) {
    this.formatter = formatter;
  }
}
