package com.wb.system.web.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInterceptor {
    @Pointcut("execution(* com.wb.system.service.IUserService.*(..))")
    // 第一个* 说明方法的类型
    // 第二个* 说明包下的所有的类  如果是包下类和自包中的类* com.cn..*.save*(..))
    // (..)方法中的参数
    private void anyMethod() {
    }

    /**
     * 当方法的参数与连接点的参数吻合的时候，才能切面编程成功。
     * 如果不设置参数，那么都会成功。
     * @param userId
     */
    @Before("anyMethod()&&args(userId)")
    public void doAccessCheck(String userId) {
        System.out.println("前置通知" + userId);
    }

    @AfterReturning("anyMethod()&&args(userId)")
    public void doAfter(String userId) {
        System.out.println("后置通知" + userId);
    }

    @After("anyMethod()")
    public void after() {
        System.out.println("最终通知");
    }

    @AfterThrowing("anyMethod()")
    public void doAfterThrow() {
        System.out.println("例外通知");
    }

    @Around("anyMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("开始环绕通知1");
        Object object = pjp.proceed();// 执行该方法
        System.out.println("结束环绕通知1");
        return object;
    }

    @Around("anyMethod()")
    public Object doBasic(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("开始环绕通知2");
        Object object = pjp.proceed();// 执行该方法
        System.out.println("结束环绕通知2");
        return object;
    }
}