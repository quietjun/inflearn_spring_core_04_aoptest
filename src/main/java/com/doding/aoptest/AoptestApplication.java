package com.doding.aoptest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
// @@TODOBLOCK: 13-1. 비동기 작업 처리를 위한 annotation을 추가하시오.
@EnableAsync
// @@END:
public class AoptestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AoptestApplication.class, args);
	}

}
