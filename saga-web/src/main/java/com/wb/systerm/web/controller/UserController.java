package com.wb.systerm.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cungubenxiaokang on 2018/8/24.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/regist")
    public String regist() {
        return "suc";
    }
}
