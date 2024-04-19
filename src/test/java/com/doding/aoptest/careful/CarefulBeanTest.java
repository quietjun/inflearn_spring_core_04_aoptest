package com.doding.aoptest.careful;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.doding.aoptest.aspects.CarefulAspect;
import com.doding.aoptest.beans.careful.CarefulBean;

@SpringBootTest
@ActiveProfiles("test")
public class CarefulBeanTest {

  @Autowired
  CarefulAspect caspect;

  @Autowired
  CarefulBean cbean;

  @Test
  public void callByOutside() {
    cbean.methodB();
    assertEquals(caspect.cnt.get(), 1);
  }
}
