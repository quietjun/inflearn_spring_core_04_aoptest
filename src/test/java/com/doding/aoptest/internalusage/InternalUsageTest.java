package com.doding.aoptest.internalusage;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.concurrent.CountDownLatch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.doding.aoptest.internalusage.BeanConfig.GPTEngine;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@ActiveProfiles("test")
public class InternalUsageTest {
  @Autowired
  private BeanConfig config;

  @Test
  public void configTest() {
    assertNotNull(config);
    log.debug("config: {}", config.getClass().getName());
  }

  @Autowired
  private GPTEngine engine;

  @Test
  public void asyncTest() throws InterruptedException {
    log.debug("engine type: {}", engine.getClass().getName());
    for (int i = 0; i < 10; i++) {
      engine.heavyWork(i);
    }
  }
}
