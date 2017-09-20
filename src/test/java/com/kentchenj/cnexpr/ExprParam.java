package com.kentchenj.cnexpr;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于输入参数的例子
 * @author Kent Chen
 *
 */
public class ExprParam {
  private String name;
  private Date startDate;
  private Date startTime;
  private Date endDate;
  private Date endTime;
  private BigDecimal salary;
  private int age;
  private boolean gender;
  private String address;
  private String email;
  private String career;
  private int status;
  private String nullData;

  public String getNullData() {
    return nullData;
  }

  public void setNullData(String nullData) {
    this.nullData = nullData;
  }

  private Map<String,String> contacts = new HashMap<String,String>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public boolean isGender() {
    return gender;
  }

  public void setGender(boolean gender) {
    this.gender = gender;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCareer() {
    return career;
  }

  public void setCareer(String career) {
    this.career = career;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public Map<String, String> getContacts() {
    return contacts;
  }

  public void setContacts(Map<String, String> contacts) {
    this.contacts = contacts;
  }
}
