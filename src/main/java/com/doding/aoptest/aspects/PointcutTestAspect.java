package com.doding.aoptest.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class PointcutTestAspect {
  // @@TODOBLOCK: 04. 다음의 주석들이 동작할 경우 어떤 target의 메서드를 대상으로 동작하는지 생각해보세요.
  // @@COMMENT: 결과는 PointcutTest.methodCallTest 에서 확인
  // @@KEEP_5
  // @Before("execution(String *..SimpleBean.getName())")
  // @Before("execution(!String com..set*(String))")
  // @Before("execution(void com..*Bean.*(*, *))")
  // @Before("execution(* com.doding..*(int, ..))")
  // @Before("execution(* *(int, ..))") // 아주 위험한 생각
  // @@END:
  public void pointcutTest(JoinPoint jp) {
    log.debug("pointcut 확인 메서드: {}", jp.getSignature());
  }
}
