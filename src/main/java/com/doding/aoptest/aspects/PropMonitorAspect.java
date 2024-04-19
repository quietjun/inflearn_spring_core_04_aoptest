// @@DELETE_FILE:
package com.doding.aoptest.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect // 이 클래스는 Advice를 담고 있다.
public class PropMonitorAspect {

  @Before("execution(void com.doding..*.set*(*))")
  public void beanPropertyChange(JoinPoint jp) {
    log.debug("AOP 동작: {}", jp.getSignature());
  }
}
