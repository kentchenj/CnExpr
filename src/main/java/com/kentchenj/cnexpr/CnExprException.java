package com.kentchenj.cnexpr;

public class CnExprException extends RuntimeException{
  public CnExprException(String errorMsg) {
    super(errorMsg);
  }

  public CnExprException(Exception e) {
    super(e);
  }

  public CnExprException(String errorMsg, Exception e) {
    super(errorMsg, e);
  }
}
