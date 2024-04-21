package com.doding.aoptest.config;

import org.springframework.scheduling.annotation.Async;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GPTEngine {
    // @@TODOBLOCK: 13-2. 다음의 무거운 작업이 비동기적으로 동작하도록 처리하시오.
    @Async
    public void heavyWork(int i) throws InterruptedException {
        Thread.sleep(1000);
        log.debug("{}에 의해 {}번째 요청 처리 중", Thread.currentThread(), i);
    }
}
