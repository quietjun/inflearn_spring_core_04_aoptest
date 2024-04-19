package com.doding.aoptest.simple;

import java.util.Calendar;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class SimpleBeanImpl implements SimpleBean {
  private String name = "orgName";
  private Calendar now = Calendar.getInstance();
}
