package com.kentchenj.cnexpr;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExprTest {

  /**
   * 简单表达式，带有 + < > <= >= () .
   */
  @Test
  public void testSimpleRule() {
    Expr expr = InstanceBuilder.getExpr();
    expr.setExpr("工资 + 1000 ");
    assertEquals(new BigDecimal(13345), expr.eval(InstanceBuilder.getExprParam()));
    assertEquals(expr.getGroovyExpr(), "obj.salary + 1000");
  }

  /**
   * 简单表达式，带有 + < > <= >= () .
   */
  @Test
  public void testIn() {
    Expr expr = InstanceBuilder.getExpr();
    expr.setExpr("工资>=10000 && 状态 in [3,5,3.14,2]");
    assertTrue((Boolean)expr.eval(InstanceBuilder.getExprParam()));
    assertEquals(expr.getGroovyExpr(), "obj.salary >= 10000 && obj.status in [3,5,3.14,2]");
  }
}
