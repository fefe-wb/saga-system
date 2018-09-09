package com.wb.system.web.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BusinessProxy implements InvocationHandler {

    private Object target;

    public BusinessProxy(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理之前日志记录");
        Object object = method.invoke(target, args);
        System.out.println("代理之后日志记录");
        return object;
    }
}
