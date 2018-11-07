package com.wb.system.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;


public class TestBean120 {

    @Autowired
    private TestBean110 testBean110;

    private String name;

    public String getName() {
        return testBean110.getName();
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestBean110 getTestBean110() {
        return testBean110;
    }

    public void setTestBean110(TestBean110 testBean110) {
        this.testBean110 = testBean110;
    }
}
