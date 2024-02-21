package com.doding.aoptest.aspects;

import java.util.concurrent.atomic.AtomicInteger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class CarefulAspect {
  public AtomicInteger cnt = new AtomicInteger(0);

  @Before("execution(* method*())")
  public void countMethodCall(JoinPoint jp) {
    log.debug("call method: {}", jp.getSignature());
    cnt.incrementAndGet();
  }

}
