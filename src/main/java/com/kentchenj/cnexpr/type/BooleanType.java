package com.kentchenj.cnexpr.type;

/**
 * 布尔类型
 * @author Kent Chen
 */
public class BooleanType extends Type{
  private String name = "boolean";

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }
}
