package com.doding.aoptest.pointcut;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class PointcutBean {
  private String oper;

  public void calc(int num1, int num2) {
    // do something
  }
}
