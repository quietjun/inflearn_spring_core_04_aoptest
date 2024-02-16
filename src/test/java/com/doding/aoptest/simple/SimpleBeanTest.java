package com.doding.aoptest.simple;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@ActiveProfiles({ "test" })
public class SimpleBeanTest {
  @Autowired
  SimpleBean sbean;

  @Test
  public void testBean() {
    assertNotNull(sbean);
    log.debug("sbean type: {}", sbean.getClass().getName());
  }

  @Test
  public void testSetName() {
    String newName = "홍길동" + Math.random();
    sbean.setName(newName);
    assertEquals(sbean.getName(), newName);// sBean의 name은 newName과 같다.
  }

  @Test
  public void testSetNow() {
    Calendar newNow = Calendar.getInstance();
    sbean.setNow(newNow);
    assertEquals(sbean.getNow(), newNow); // sBean의 now는 newNow와 같다.
  }
}
