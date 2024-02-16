package com.doding.aoptest.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect // 이 클래스는 Advice를 담고 있다.
@Slf4j
public class PropMonitorAspect {

  // @@TODOBLOCK: execution(void com.doding..*.set*(*)) 을 pointcut으로 메서드 시작 전 동작하는 advice를 작성하세요.
  @Before("execution(void com.doding..*.set*(*))")
  public void beanPropertyWillChange(JoinPoint jp) {
    log.debug("AOP 동작: {}", jp.getSignature());
  }
  // @@END:
}
