package com.kentchenj.cnexpr.type;

/**
 * 字符串类型
 * @author Kent Chen
 */
public class StringType extends Type{
  private String name = "string";

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) {
    this.setName(name);
  }
}
