package com.kentchenj.cnexpr;

import com.kentchenj.cnexpr.core.GroovyExecutor;
import com.kentchenj.cnexpr.core.ScriptBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Expr
 *
 * @author Kent Chen
 */
public class Expr {
  private List<String> imports = new ArrayList<>(); //import语句
  private List<String> paraNames = new ArrayList<>(); //参数名，例如：obj
  private String expr; //表达式
  private String groovyExpr;//转换后的groovy表达式
  private Map<String, Factor> factorMap = new HashMap<>();//存储因子

  public String getExpr() {
    return expr;
  }

  public void setExpr(String expr) {
    this.expr = expr;
  }

  public String getGroovyExpr() {
    return groovyExpr;
  }

  public void setGroovyExpr(String groovyExpr) {
    this.groovyExpr = groovyExpr;
  }

  public void addImport(String importStr) {
    this.imports.add(importStr);
  }

  public List<String> getImports() {
    return this.imports;
  }

  public void addFactor(Factor factor) {
    this.factorMap.put(factor.getName(), factor);
  }

  public Factor getFactor(String name) {
    return this.factorMap.get(name);
  }

  public Map<String, Factor> getFactorMap() {
    return this.factorMap;
  }

  public List<String> getParaNames(){
    return this.paraNames;
  }

  public void addParaName(String paraName) {
    this.paraNames.add(paraName);
  }

  public void clearParaNames(){
    this.paraNames.clear();
  }

  /**
   * 执行，默认参数是obj
   * @param object
   * @return
   */
  public Object eval(Object object) {
    ScriptBuilder scriptBuilder = ScriptBuilder.getInstance();
    String groovyScript = scriptBuilder.build(this);
    return GroovyExecutor.getInstance().execute(groovyScript, "obj", object);
  }

  /**
   * 执行
   * @param typeName
   * @param object
   * @return
   */
  public Object eval(String typeName, Object object) {
    ScriptBuilder scriptBuilder = ScriptBuilder.getInstance();
    String groovyScript = scriptBuilder.build(this);
    return GroovyExecutor.getInstance().execute(groovyScript, typeName, object);
  }

  /**
   * 执行：多个参数
   * @param params
   * @return
   */
  public Object eval(Map<String,Object> params){
    ScriptBuilder scriptBuilder = ScriptBuilder.getInstance();
    String groovyScript = scriptBuilder.build(this);
    return GroovyExecutor.getInstance().execute(groovyScript, params);
  }
}
