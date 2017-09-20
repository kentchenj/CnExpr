package com.kentchenj.cnexpr;

import com.kentchenj.cnexpr.type.Type;

/**
 * 中文化的因子
 * @author Kent Chen
 */
public class Factor {
  private String code; //因子内容
  private String name; //因子名称
  private Type type;

  public Factor(String code, String name) {
    this.code = code;
    this.name = name;
  }

  public Factor(){
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }
}
