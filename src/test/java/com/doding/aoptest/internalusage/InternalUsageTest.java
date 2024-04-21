package com.doding.aoptest.internalusage;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import com.doding.aoptest.config.BeanConfig;
import com.doding.aoptest.config.GPTEngine;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@ActiveProfiles("test")
public class InternalUsageTest {
  @Autowired
  private BeanConfig config;

  @Test
  public void configTest() {
    // @@TODOBLOCK: 12-1. BeanConfig의 클래스를 확인하세요.
    assertNotNull(config);
    assertNotEquals(config.getClass(), BeanConfig.class);
    // @@END:
  }

  @Autowired
  private GPTEngine engine;

  @Test
  public void asyncTest() throws InterruptedException {
    // @@TODOBLOCK: 13-3, heavyWork를 호출하고 비동기로 동작하는지 확인하시오.
    log.debug("engine type: {}", engine.getClass().getName());
    for (int i = 0; i < 10; i++) {
      engine.heavyWork(i);
    }
    // @@END:
  }
}
