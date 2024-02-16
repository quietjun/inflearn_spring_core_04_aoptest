package com.doding.aoptest.pointcut;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.doding.aoptest.simple.SimpleBean;

@SpringBootTest
@ActiveProfiles("test")
public class PointcutTest {

  @Autowired
  PointcutBean pBean;

  @Autowired
  SimpleBean sBean;

  @Test
  public void methodCallTest() throws Exception {
    pBean.setOper("*");
    pBean.getOper();
    pBean.calc(100, 200);
    sBean.setName("홍길동");
    sBean.getName();
    sBean.setNow(Calendar.getInstance());
    sBean.getNow();
  }
}