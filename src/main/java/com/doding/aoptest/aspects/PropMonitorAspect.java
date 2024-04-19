// @@DELETE_FILE:
package com.doding.aoptest.aspects;

// @@TODOBLOCK: 03. sbean의 setter가 호출될 때 해당 메서드의 정보를 출력하는 Aspect를 만들어보세요.
// @@COMMENT: Aspect를 작성 후 앞서 작성했던 테스트를 실행하고 결과를 확인하세요.
// @@REPLACE: public class PropMonitorAspect{}
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
// @@END: