package com.wb.system.web.controller;


import com.wb.system.delegate.GetUserInfoCommand;
import com.wb.system.model.dao.UserInfo;
import com.wb.system.service.IUserService;
import com.wb.system.service.impl.UserServiceImpl;
import com.wb.system.util.kafka.KafkaProducerServer;
import com.wb.system.web.proxy.BusinessProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Proxy;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by cungubenxiaokang on 2018/8/24.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private KafkaProducerServer kafkaProducer;

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String regist(@RequestParam String userId, @RequestParam String userName, @RequestParam int age,
                         @RequestParam String mobileNo, @RequestParam String address, @RequestParam int sex) {
        int res = userService.saveUserInfo(new UserInfo(userId, mobileNo, userName, age, sex, address, new Date(), new Date()));
        return "成功插入" + res + "条数据！！！";
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String select(@RequestParam String userId) throws InterruptedException {
        UserInfo userInfo = userService.getUserInfo(userId);
        System.out.println(userInfo.toString());
        TimeUnit.SECONDS.sleep(5);
        return userInfo.toString();
    }

    @RequestMapping(value = "/selectFromProxy", method = RequestMethod.GET)
    public String selectFromProxy(@RequestParam String userId) {
        IUserService proxyInstance = (IUserService) Proxy.newProxyInstance(
                UserController.class.getClassLoader(), UserServiceImpl.class.getInterfaces(), new BusinessProxy(userService));
        UserInfo userInfo = proxyInstance.getUserInfo(userId);
        System.out.println(userInfo.toString());
        return userInfo.toString();
    }

//    @RequestMapping(value = "/selectFromCGLIBProxy", method = RequestMethod.GET)
//    public String selectFromCGLIBProxy(@RequestParam String userId) {
//        UserServiceImpl proxyInstance = BusinessCGLIBProxy.create();
//        proxyInstance.sayHello();
//        return "suc";
//    }

    @RequestMapping(value = "/sendKafkaMsg")
    public String sendKafkaMsg(@RequestParam String topic, @RequestParam String msg) {
        Map<String,Object> res = kafkaProducer.sndMesForTemplate(topic, msg);

        System.out.println("测试结果如下：===============");
        String message = (String)res.get("message");
        String code = (String)res.get("code");

        System.out.println("code:"+code);
        System.out.println("message:"+message);
        return "success";
    }

    @RequestMapping(value = "/selectFromHystrix", method = RequestMethod.GET)
    public String selectFromHystrix(@RequestParam String userId) {
        GetUserInfoCommand getUserInfoCommand = new GetUserInfoCommand(userService, userId);
        UserInfo userInfo = getUserInfoCommand.execute();
        System.out.println(userInfo.toString());
        return userInfo.toString();
    }

    @RequestMapping(value = "/crateData", method = RequestMethod.GET)
    public String crateData() {

        for (int i=0;i<10;i++) {
            List<UserInfo> userInfos = userService.getAllUserInfo();
            for (UserInfo userInfo : userInfos) {
                userInfo.setUserId(String.valueOf(Integer.valueOf(userInfo.getUserId()) + userInfos.size()));
                userInfo.setUserName(userInfo.getUserName());
                userInfo.setAge((int)(Math.random() * 10));
                userService.saveUserInfo(userInfo);
            }
        }
        return "success";
    }
}