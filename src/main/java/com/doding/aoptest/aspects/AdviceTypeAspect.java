package com.doding.aoptest.aspects;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class AdviceTypeAspect {
  // @@TODOBLOCK: 05-1. AdviceTypeBean의 setData가 호출될 때 전달된 파라미터를 조작하도록 aspect를 작성하세요.
  @Before("execution(void *..AdviceTypeBean.setData(String, java.util.List))")
  public void beforeAdvice(JoinPoint jp) {
    log.debug("@Before signature:{}", jp.getSignature());
    // 전달되는 파라미터 확인
    Object[] args = jp.getArgs();
    args[0] = "new Value"; // 완전히 새로운 객체 할당
    @SuppressWarnings(value = "unchecked")
    List<String> skils = (List<String>) args[1];
    skils.set(0, "spring"); // 객체의 내용 변경
  }
  // @@END:

  // @@TODOBLOCK: 06-1. getGugu 함수에 대한 validation을 처리할 advice를 작성해보세요.
  @Before("execution(int *..AdviceTypeBean.*Gugu(int, int) )")
  public void checkNumRange(JoinPoint jp) {
    Object[] args = jp.getArgs();
    Integer a = (Integer) args[0];
    Integer b = (Integer) args[1];
    if (a < 1 || a > 9 || b < 1 || b > 9) {
      throw new RuntimeException("구구단은 1~9까지의 수를 곱한다.");
    }
  }
  // @@END:

  // @@TODOBLOCK: 07-1. AdviceTypeBean의 getXX 메서드 호출 시 반환되는 타입을 조작해보세요.
  // @AfterReturning 반환된 리턴값이 String이면 name에 할당된다.
  @AfterReturning(value = "execution(* *..AdviceTypeBean.get*())", returning = "retvalue")
  public void afterReturningName(JoinPoint jp, Object retvalue) {
    log.debug("@AfterReturning signature: {}, target 반환값: {}", jp.getSignature(), retvalue);
    if (retvalue instanceof String) {
      retvalue = "수정된 이름"; // 반환값을 바꿔보지만 반영되지는 않는다.
    } else {
      @SuppressWarnings(value = "unchecked")
      List<String> skills = (List<String>) retvalue;
      log.debug("조작 전: {}", retvalue);
      skills.set(1, "springboot");
      log.debug("조작 후: {}", retvalue);
    }
  }
  // @@END:

  // @@TODOBLOCK: 08-1. AdviceTypeBean의 divideBy 메서드 호출 시 던져지는 예외를 모니터링해보세요.
  // @AfterThrowing에서 던져진 예외는 ex 변수로 처리해보자.
  @AfterThrowing(value = "execution(* *..AdviceTypeBean.divideBy(int))", throwing = "ex")
  public void afterThrowingAdvice(JoinPoint jp, RuntimeException ex) {
    log.debug("@AfterThrowing signature: {}, ex: {}", jp.getSignature(), ex.getClass().getName());
    log.debug("예외 내용: {}, 조치내용: {}", ex.getMessage(), "담당자 이메일로 내용 전송");
  }
  // @@END:

  // @@TODOBLOCK: 09-1. getGugu가 호출될 때 파라미터와 반환값을 출력하는 로그를 출력해보세요.
  @AfterReturning(value = "execution(* *..AdviceTypeBean.getGugu(..))", returning = "result")
  public void printGuguResult(JoinPoint jp, Integer result) {
    String msg = """
        \n========================================================
        method : %s
        parameter: %s,
        return: %d
        =========================================================
          """.formatted(jp.getSignature(), Arrays.toString(jp.getArgs()), result);
    log.debug(msg);
  }
  // @@END:


  // @@TODOBLOCK: 10-1. add가 호출될 때 전달되는 파라미터를 각각 10배로 하고 결과를 2로 조작하도록 around에서 처리해보세요.
  @Around("execution(int *..AdviceTypeBean.add(int, int))")
  public Integer modifyAdd(ProceedingJoinPoint pjp) throws Throwable {
    StopWatch watch = new StopWatch();
    watch.start();
    Object[] args = pjp.getArgs();
    args[0] = (Integer) args[0] * 10; // 1. 파라미터 완전 대체 가능
    Integer result = (Integer) pjp.proceed(args); // 2. 타겟의 메서드 호출
    log.debug("소요 시간: {}, 타겟 리턴: {}", watch.getTotalTimeMillis());
    return result % 2 == 0 ? result : result / 2; // 3. 결과 조작 가능
  }
  // @@END:

  // @@TODOBLOCK: 11-1. 이미 구해놓은 factorial 값을 cache에서 관리하도록 처리해보세요.
  private Map<Object, BigInteger> factorialCache = new HashMap<>();

  @Around("execution(java.math.BigInteger *..AdviceTypeBean.getFactorial(int))")
  public BigInteger handleFactorial(ProceedingJoinPoint pjp) throws Throwable {
    StopWatch watch = new StopWatch();
    watch.start();
    Object[] args = pjp.getArgs();
    BigInteger result = factorialCache.get(args[0]); // 전처리: 이미 구해놓은 factorial 확인
    if (result == null) {
      result = (BigInteger) pjp.proceed(args); // 타겟의 메서드 호출
      factorialCache.put(args[0], result); // 후처리: hash update
    }
    log.debug("소요 시간: {}, 결과: {}", watch.getTotalTimeMillis(), result);
    return result;
  }
  // @@END:
}
