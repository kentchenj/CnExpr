package com.kentchenj.cnexpr.core;

import com.kentchenj.cnexpr.CnExprException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.*;
import java.util.Map;

/**
 * 表达式执行器
 *
 * @author Kent Chen
 */
public class GroovyExecutor {
  private final static Logger logger = LoggerFactory.getLogger(GroovyExecutor.class);
  public static String funcName = "evalCnExpr";
  private static GroovyExecutor groovyExecutor = new GroovyExecutor();

  private GroovyExecutor() {
  }

  public static GroovyExecutor getInstance() {
    return groovyExecutor;
  }

  /**
   * 执行groovy函数脚本
   *
   * @param script         groovy脚本
   * @param objectTypeName 对象名称，例如：obj
   * @param param          参数，可以是多个对象
   * @return Object
   */
  public Object execute(String script, String objectTypeName, Object... param) throws CnExprException {
    try {
      ScriptEngine engine = getScriptEngine();
      Compilable compilable = (Compilable) engine;
      StringBuilder evalScript = new StringBuilder(script);
      evalScript.append(";\n").append(funcName).append("(").append(objectTypeName).append(");");
      CompiledScript compiledScript = compilable.compile(evalScript.toString());
      Bindings bindings = engine.createBindings();
      for(Object obj : param){
        bindings.put(objectTypeName, obj); //只能传一个参数名
      }

      return compiledScript.eval(bindings);
    } catch (ScriptException e) {
      throw new CnExprException("Expr definition Error: \n" + script, e);
    }
  }

  /**
   * 执行groovy函数脚本
   *
   * @param script         groovy脚本
   * @param param          参数，可以是多个对象
   * @return Object
   */
  public Object execute(String script, Map<String,Object> param) throws CnExprException {
    try {
      ScriptEngine engine = getScriptEngine();
      Compilable compilable = (Compilable) engine;
      StringBuilder evalScript = new StringBuilder(script);
      String params = String.join(",", param.keySet());
      evalScript.append(";\n").append(funcName).append("(").append(params).append(");");
      CompiledScript compiledScript = compilable.compile(evalScript.toString());
      Bindings bindings = engine.createBindings();
      for(String key : param.keySet()){
        bindings.put(key, param.get(key)); //只能传一个参数名
      }
      return compiledScript.eval(bindings);
    } catch (ScriptException e) {
      throw new CnExprException("Expr definition Error: \n" + script, e);
    }
  }

  private ScriptEngine scriptEngine;

  private ScriptEngine getScriptEngine() {
    if (this.scriptEngine == null) {
      ScriptEngineManager factory = new ScriptEngineManager();
      this.scriptEngine = factory.getEngineByName("groovy");
    }
    return this.scriptEngine;
  }
}
