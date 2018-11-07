package com.wb.system.web.controller;


import com.wb.system.delegate.GetUserInfoCommand;
import com.wb.system.model.dao.UserInfo;
import com.wb.system.service.IUserService;
import com.wb.system.service.impl.UserServiceImpl;
import com.wb.system.util.kafka.KafkaProducerServer;
import com.wb.system.web.proxy.BusinessProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rx.internal.util.LinkedArrayList;

import java.lang.reflect.Proxy;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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

    public static void main(String[] args) throws Exception {
//        HashMap<String, Integer> map = new HashMap<String, Integer>();
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            entry.getKey();
//        }
//
//        Lock lock = new ReentrantLock();
//        lock.lock();


//        List<String> list = new ArrayList<String>();
//        list.add("wubing");
//        list.get(1);
//        list.remove(1);
//        list.remove("wubing");
//
//        ThreadLocal threadLocal = new ThreadLocal();
//        threadLocal.set(123);
//
//        HashMap<String, Integer> map = new HashMap<String, Integer>();
//        for (int i=0;i<10;i++) {
//            map.put("wubing", i);
//        }
//        map.get("1");
//
//        AtomicInteger atomicInteger = new AtomicInteger(1);
//        atomicInteger.incrementAndGet();
//
//        LinkedArrayList linkedArrayList = new LinkedArrayList(1);
//        linkedArrayList.add("wubing");
//        LinkedList<String> linkedList = new LinkedList<String>();
//        linkedList.add("wubing");
//        linkedList.get(1);
//
//        Set<String> set = new HashSet<String>();
//        set.add("wubing");
//        LinkedHashSet<String> set1 = new LinkedHashSet<String>();
//        set1.add("wubing");
//        set1.iterator();

//        System.out.println(Float.MAX_VALUE);
//        System.out.println(Float.MIN_VALUE);
//
//        float x = 4;
//        System.out.println(x);
//
//        byte a = 127;
//        char b = 'c';
//        System.out.println(a);
//        System.out.println(b);

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        TestBean120 testBean120 = (TestBean120) context.getBean("testBean120");
        System.out.println(testBean120.getName());

        ExecutorService executorService = Executors.newScheduledThreadPool(1);
        Future future = executorService.submit(new Callable<String>() {
            public String call() throws Exception {
                return null;
            }
        });
        future.get();
    }
}