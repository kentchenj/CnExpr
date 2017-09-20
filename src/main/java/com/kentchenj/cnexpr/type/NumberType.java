package com.kentchenj.cnexpr.type;

/**
 * 数字类型
 * @author Kent Chen
 */
public class NumberType extends Type{
  private String name = "number";

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }
}
