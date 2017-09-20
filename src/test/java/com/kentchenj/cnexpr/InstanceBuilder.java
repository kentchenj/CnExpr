package com.kentchenj.cnexpr;


import com.kentchenj.cnexpr.type.DateType;
import com.kentchenj.cnexpr.type.DatetimeType;
import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * 样例对象生成器
 * @author Kent Chen
 */
public class InstanceBuilder {

  /**
   * 获得参数对象
   * @return
   */
  public static ExprParam getExprParam() {
    //构造执行对象
    ExprParam exprParam = new ExprParam();
    exprParam.setName("Kent Chen");
    exprParam.setStartDate(new DateTime(2016, 7, 1, 1, 2, 3).toDate());
    exprParam.setEndDate(new DateTime(2016, 7, 1, 11, 12, 13).toDate());
    exprParam.setStartTime(new DateTime(2016, 7, 1, 1, 2, 3).toDate());
    exprParam.setEndTime(new DateTime(2016, 7, 1, 11, 12, 13).toDate());
    exprParam.setSalary(new BigDecimal(12345));
    exprParam.setAge(30);
    exprParam.setGender(true);
    exprParam.setAddress("中国上海浦东新区");
    exprParam.setEmail("kentchenj@github.com");
    exprParam.setCareer("engineer");
    exprParam.setStatus(2);
    exprParam.getContacts().put("email","chenjian@github.com");
    return exprParam;
  }

  /**
   * 获得expr
   * @return
   */
  public static Expr getExpr(){
    Expr expr = new Expr();
    expr.addParaName("obj"); //增加参数

    expr.addImport("org.joda.time.*");
    expr.addImport("org.joda.time.format.*");
    expr.addImport("com.kentchenj.cnexpr.utils.*");


    //设置各字段
    Factor salaryFactor = new Factor();
    salaryFactor.setCode("obj.salary");
    salaryFactor.setName("工资");
    expr.addFactor(salaryFactor);

    Factor ageFactor = new Factor();
    ageFactor.setCode("obj.age");
    ageFactor.setName("年龄");
    expr.addFactor(ageFactor);

    Factor addressFactor = new Factor();
    addressFactor.setCode("obj.address");
    addressFactor.setName("地址");
    expr.addFactor(addressFactor);

    Factor startDateFactor = new Factor();
    startDateFactor.setCode("obj.startDate");
    startDateFactor.setName("开始日期");
    startDateFactor.setType(new DateType());
    expr.addFactor(startDateFactor);

    Factor endDateFactor = new Factor();
    endDateFactor.setCode("obj.endDate");
    endDateFactor.setName("结束日期");
    endDateFactor.setType(new DateType());
    expr.addFactor(endDateFactor);

    Factor startTimeFactor = new Factor();
    startTimeFactor.setCode("obj.startTime");
    startTimeFactor.setName("开始时间");
    startTimeFactor.setType(new DatetimeType());
    expr.addFactor(startTimeFactor);

    Factor endTimeFactor = new Factor();
    endTimeFactor.setCode("obj.endTime");
    endTimeFactor.setName("结束时间");
    endTimeFactor.setType(new DatetimeType());
    expr.addFactor(endTimeFactor);

    Factor careerFactor = new Factor();
    careerFactor.setCode("obj.career");
    careerFactor.setName("职业");
    expr.addFactor(careerFactor);

    Factor statusFactor = new Factor();
    statusFactor.setCode("obj.status");
    statusFactor.setName("状态");
    expr.addFactor(statusFactor);

    Factor emailFactor = new Factor();
    emailFactor.setCode("obj.contacts[\"email\"]");
    emailFactor.setName("电邮");
    expr.addFactor(emailFactor);

    //自定义Fn
    Factor salaryFnFactor = new Factor();
    salaryFnFactor.setCode("{salary->salary>10000}(obj.salary)");
    salaryFnFactor.setName("工资是否大于10000");
    expr.addFactor(salaryFnFactor);

    //自定义黑名单Fn1
    Factor blackListFactor1 = new Factor();
    blackListFactor1.setCode("{it->[\"engineer\",\"teacher\",\"boss\"]}()");
    blackListFactor1.setName("黑名单1");
    expr.addFactor(blackListFactor1);

    //自定义黑名单Fn2
    Factor blackListFactor2 = new Factor();
    blackListFactor2.setCode("{it->[\"lawyer\",\"programmer\",\"boss\"]}()");
    blackListFactor2.setName("黑名单2");
    expr.addFactor(blackListFactor2);

    //转大写函数
    Factor upperFactor = new Factor();
    upperFactor.setCode("{it->it.toUpperCase()}");
    upperFactor.setName("转换成大写");
    expr.addFactor(upperFactor);

    //取前几位函数
    Factor subStrFactor = new Factor();
    subStrFactor.setCode("{it,length->it.substring(0,length)}");
    subStrFactor.setName("取前几位");
    expr.addFactor(subStrFactor);

    //空值字段
    Factor nullDataFactor = new Factor();
    nullDataFactor.setCode("obj.nullData");
    nullDataFactor.setName("空值字段");
    expr.addFactor(nullDataFactor);

    return expr;
  }
}
