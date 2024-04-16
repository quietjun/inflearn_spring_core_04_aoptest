package com.doding.aoptest.joinpoint;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class JoinPointBean {

  private String name;
  private List<String> skills;

  public void setData(String name, List<String> skills) {
    this.name = name;
    this.skills = skills;
  }

  public void divideBy(int divider) {
    int i = 100;
    System.out.printf("%d/%d=%d%n", i, divider, i / divider);
  }

  public int add(int a, int b) {
    return a + b;
  }

  public String toString() {
    return "name: " + name + ", skils: " + skills;
  }
}