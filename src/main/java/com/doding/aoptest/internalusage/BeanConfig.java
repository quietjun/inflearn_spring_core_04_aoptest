package com.doding.aoptest.internalusage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class BeanConfig {

  @Bean
  public GPTEngine engine() { // engine()가 불리면 GPTEngine 만들어졌을 것!
    return new GPTEngine();
  }

  @Bean
  public ChatGPTService service() { // service()가 불리면 ChatGPTService 만드는데.
    return new ChatGPTService(engine()); // 내부적으로 engine()을 부른다. 또 만드는 것일까?
  }

  class GPTEngine {
    @Async
    public void heavyWork(int i) throws InterruptedException {
      Thread.sleep(1000);
      log.debug("{}에 의해 {}번째 요청 처리 중", Thread.currentThread(), i);
    }
  }

  class ChatGPTService {
    GPTEngine engine;

    public ChatGPTService(GPTEngine engine) {
      this.engine = engine;
    }
  }
}