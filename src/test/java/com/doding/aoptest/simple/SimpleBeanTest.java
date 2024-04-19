package com.doding.aoptest.simple;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.doding.aoptest.beans.simple.SimpleBean;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@ActiveProfiles({ "test" })
public class SimpleBeanTest {
  @Autowired
  SimpleBean sbean;

  @Test
  public void testSetName() {
    String newName = "홍길동";
    sbean.setName(newName);
    assertEquals(sbean.getName(), newName);// sBean의 name은 newName과 같다.
  }

  @Test
  public void testSetNow() {
    Calendar newNow = Calendar.getInstance();
    sbean.setNow(newNow);
    assertEquals(sbean.getNow(), newNow); // sBean의 now는 newNow와 같다.
  }

  // @@TODOBLOCK: 01. simpleBean의 타입을 확인해보세요.
  @Test
  @DisplayName("실제로 생성된 빈의 타입 확인")
  public void testBean() {
    // assertEquals(sbean.getClass(), SimpleBean.class);
    log.debug("sbean type: {}", sbean.getClass().getName());
  }
  // @@END:

}
