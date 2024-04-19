// @@DELETE_FILE:
package com.doding.aoptest.beans.simple;

import java.util.Calendar;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class SimpleBeanImpl implements SimpleBean {
  private String name;
  private Calendar now;
}