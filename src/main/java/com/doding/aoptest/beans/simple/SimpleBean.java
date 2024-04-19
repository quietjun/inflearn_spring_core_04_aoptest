package com.doding.aoptest.beans.simple;

import java.util.Calendar;

public interface SimpleBean {
  public void setName(String name);

  public String getName();

  public void setNow(Calendar cal);

  public Calendar getNow();
  // @@TODOBLOCK: 02. SimpleBean을 구현하는 SimpleBeanImpl을 작성해보세요.
  // @@END:
}
