package com.doding.aoptest.beans.careful;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CarefulBean {
  public void methodA() {
    log.debug("methodA");
  }

  public void methodB() {
    log.debug("methodB");
    methodA();
  }
}
