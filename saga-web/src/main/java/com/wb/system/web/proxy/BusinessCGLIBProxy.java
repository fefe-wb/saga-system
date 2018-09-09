package com.wb.system.web.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

public class BusinessCGLIBProxy {

    public static <T> T create(final T t) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(BusinessCGLIBProxy.class.getClassLoader());
        enhancer.setSuperclass(t.getClass().getSuperclass());
        enhancer.setCallback(new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object ret=null;
                doBefore();
                try {
                    ret=method.invoke(t, args);
                } catch (Exception e) {
                    doThrowing();
                }
                doAfter();
                return ret;
            }

        });
        return (T)enhancer.create();
    }

    private static void doThrowing() {
        System.out.println("AOP say throw a exception");
    }

    private static void doBefore() {
        System.out.println("AOP before say");
    }

    private static void doAfter() {
        System.out.println("AOP after say");
    }
}
