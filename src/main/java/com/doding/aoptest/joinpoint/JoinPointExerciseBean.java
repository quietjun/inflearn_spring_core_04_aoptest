package com.doding.aoptest.joinpoint;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Component
@Data
@Slf4j
public class JoinPointExerciseBean {

  public int getGugu(int a, int b) {
    /*
    if (a < 1 || a > 9 || b < 1 || b > 9) {
      throw new RuntimeException("구구단은 1~9까지의 수를 곱한다.");
    }
    */
    int result = a * b;
    /*
    log.debug("전달 파라미터: a: {}, b: {}", a, b);
    log.debug("동작 결과: {}", result);
    */
    return result;
  }

  private Map<Object, BigInteger> factorialCache = new HashMap<>();

  public BigInteger getFactorial(int n) {
    /* 
    long start = System.nanoTime();
    if (factorialCache.containsKey(n)) {
      return factorialCache.get(n);
    }
    */

    BigInteger result = new BigInteger("1");
    for (int i = 1; i < n; i++) {
      result = result.multiply(BigInteger.valueOf(i));
    }
    //factorialCache.put(n, result);
    //log.debug("소요 시간: {}, 결과: {}", System.nanoTime() - start, result);
    return result;

  }
}
