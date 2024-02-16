package com.doding.aoptest.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class PointcutTestAspect {
  // @Before("execution(String *..SimpleBean.getName())")
  // @Before("execution(!String com..set*(String))")
  // @Before("execution(void com..*Bean.*(*, *))")
  // @Before("execution(* *(int, ..))") // 아주 위험한 생각
  // @Before("execution(* com.doding..*(int, ..))")
  public void pointcutTest(JoinPoint jp) {
    log.debug("pointcut 확인 메서드: {}", jp.getSignature());
  }
}
