package com.doding.aoptest.beans.simple;

import java.util.Calendar;

public interface SimpleBean {
  public void setName(String name);

  public String getName();

  public void setNow(Calendar now);

  public Calendar getNow();
}
