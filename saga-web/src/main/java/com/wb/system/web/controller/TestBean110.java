package com.wb.system.web.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class TestBean110 {

    private String name = "wubing";
    private int age;

    private TestBean120 testBean120;

    public TestBean120 getTestBean120() {
        return testBean120;
    }

    public void setTestBean120(TestBean120 testBean120) {
        this.testBean120 = testBean120;
    }

    public TestBean110() {
        System.out.println("00");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
