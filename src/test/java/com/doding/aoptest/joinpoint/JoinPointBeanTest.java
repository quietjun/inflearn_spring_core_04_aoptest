package com.doding.aoptest.joinpoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@ActiveProfiles("test")
public class JoinPointBeanTest {
  @Autowired
  JoinPointBean jBean;
  @Autowired
  JoinPointExerciseBean eBean;

  @Test
  @DisplayName("@Before 테스트: 첫 번째 인자는 EJB였지만 spring으로 변경됨")
  public void beforeTest1() {
    // 처음 값은 "org name"과 ["EJB"]을 넘겨준다.
    String name = "org name";
    jBean.setData(name, Arrays.asList("EJB", "JSP"));
    // 실제로 세팅된 값은?
    log.debug("jBean: {}", jBean.toString()); // jBean: name: org name, year: 2000
    assertEquals(jBean.getName(), name);
    assertEquals(jBean.getSkills().get(0), "spring");
  }

  @Test
  @DisplayName("getGugu 메서드 파라미터 범위 검증 확인, 1~9까지는 정상, 아니면 RuntimeException 발생")
  public void beforeTest2() {
    // @@TODOBLOCK: JoinPointExerciseBean의 getGugu의 호출 파라미터 범위에 대한 동작을 테스트 하시오.
    RuntimeException e = assertThrows(RuntimeException.class, () -> {
      eBean.getGugu(-1, 10);
    });
    assertEquals(e.getMessage(), "구구단은 1~9까지의 수를 곱한다.");
    assertEquals(eBean.getGugu(2, 3), 6);
    // @@END:
  }

  @Test
  @DisplayName("리스트의 1번째 요소로 JSP를 담았고 리턴 되었지만 springboot로 변경됨")
  public void afterReturningTest() {
    String name = "org name";
    List<String> skills = Arrays.asList("EJB", "JSP");
    jBean.setData(name, skills);
    assertEquals(jBean.getName(), name);
    assertEquals(jBean.getSkills().get(1), "springboot");
  }

  @Test
  @DisplayName("getGugu 호출 결과에 대한 로깅 테스트")
  public void getGuguResultTest() {
    // @@TODOBLOCK: JoinPointExerciseBean의 getGugu 호출 시 로그가 잘 출력되는지 테스트 하시오.
    int result = eBean.getGugu(8, 9);
    assertEquals(result, 8 * 9);
    // @@END:
  }

  @Test
  @DisplayName("0으로 나누면 RuntimeException 발생")
  public void afterThrowingTest() {
    jBean.divideBy(10);
    assertThrows(RuntimeException.class, () -> jBean.divideBy(0));
  }

  @Test
  @DisplayName("전달한 값의 파라미터 및 결과 자체의 조작 가능")
  public void aroundAddTest() {
    int a = 10;
    int b = 3;
    int temp = a * 10 + b;
    int result = jBean.add(a, b);

    assertEquals(result, temp % 2 == 0 ? temp : temp / 2);
  }

  @Test
  @DisplayName("cache를 이용한 factorial 확인")
  public void aroundTest() {
    BigInteger bi1 = eBean.getFactorial(10);
    BigInteger bi2 = eBean.getFactorial(10);
    assertEquals(bi1, bi2);
  }
}
