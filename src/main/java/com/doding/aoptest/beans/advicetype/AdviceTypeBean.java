package com.doding.aoptest.beans.advicetype;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class AdviceTypeBean {

  private String name;
  private List<String> skills;

  public void setData(String name, List<String> skills) {
    this.name = name;
    this.skills = skills;
  }

  public void divideBy(int divider) {
    int i = 100;
    System.out.printf("%d/%d=%d%n", i, divider, i / divider);
  }

  public int add(int a, int b) {
    return a + b;
  }

  public String toString() {
    return "name: " + name + ", skils: " + skills;
  }

  // 구구단의 피 연산자는 1~9 사이의 값
  public int getGugu(int a, int b) {
    /*
     * if (a < 1 || a > 9 || b < 1 || b > 9) { throw new RuntimeException("구구단은 1~9까지의 수를 곱한다."); }
     */
    int result = a * b;
    // System.out.printf("a: %d, b: %d, result : %d\n", a, b, result);
    return result;
  }

  private Map<Object, BigInteger> factorialCache = new HashMap<>();

  public BigInteger getFactorial(int n) {
    /*
     * long start = System.nanoTime(); if (factorialCache.containsKey(n)) { return
     * factorialCache.get(n); }
     */

    BigInteger result = new BigInteger("1");
    for (int i = 1; i < n; i++) {
      result = result.multiply(BigInteger.valueOf(i));
    }
    // factorialCache.put(n, result);
    // log.debug("소요 시간: {}, 결과: {}", System.nanoTime() - start, result);
    return result;

  }
}
