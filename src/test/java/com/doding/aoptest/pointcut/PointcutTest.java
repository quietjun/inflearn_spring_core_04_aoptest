package com.doding.aoptest.pointcut;

import java.util.Calendar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.doding.aoptest.beans.pointcut.PointcutBean;
import com.doding.aoptest.beans.simple.SimpleBean;

@SpringBootTest
@ActiveProfiles("test")
public class PointcutTest {

  @Autowired
  PointcutBean pBean;

  @Autowired
  SimpleBean sBean;

  @Test
  @DisplayName("다양한 메서드 호출과 연결되는 Pointcut 확인")
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