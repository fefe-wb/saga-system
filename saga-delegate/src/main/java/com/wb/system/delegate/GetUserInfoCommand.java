package com.wb.system.delegate;

import com.netflix.hystrix.*;
import com.wb.system.model.dao.UserInfo;
import com.wb.system.service.IUserService;

import java.util.concurrent.TimeUnit;

/**
 * 每个CommandKey代表一个依赖抽象,相同的依赖要使用相同的CommandKey名称。依赖隔离的根本就是对相同CommandKey的依赖做隔离.
 */
public class GetUserInfoCommand extends HystrixCommand<UserInfo> {

    private String userId;
    private IUserService userService;

    public GetUserInfoCommand(IUserService userService, String userId) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ServiceGroup"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("servcie1query"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("service1ThreadPool"))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                        .withCoreSize(10)//服务线程池数量
                        .withQueueSizeRejectionThreshold(5) // 设置队列拒绝的阈值——一个人为设置的拒绝访问的最大队列值，即使maxQueueSize还没有达到。默认值：5.注意：如果maxQueueSize设置为-1，该属性不可用。
                        .withMaxQueueSize(10) //设置BlockingQueue最大的队列值。如果设置为-1，那么使用SynchronousQueue，否则正数将会使用LinkedBlockingQueue。默认值：-1
                        .withKeepAliveTimeMinutes(1))//设置存活时间，单位分钟.默认值：1
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionTimeoutEnabled(true) // 默认也是开启超时
                        .withExecutionTimeoutInMilliseconds(10000) // 默认超时时间1000毫秒
                        .withExecutionIsolationThreadInterruptOnTimeout(true) // 命令执行发生超时后，是否中断，默认是true
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)//默认也是线程池隔离
                        .withFallbackIsolationSemaphoreMaxConcurrentRequests(10) // 如果达到最大并发数目，后续请求将会被拒绝，如果没有实现回退，则抛出异常.默认值：10
                        .withCircuitBreakerRequestVolumeThreshold(20) // 比如：如果值是20，在一个窗口内（比如10秒），收到19个请求，即使这19个请求都失败了，断路器也不会打开。默认值：20
                        .withRequestCacheEnabled(true) //设置HystrixCommand.getCacheKey()是否启用 默认值：true
                        .withCircuitBreakerErrorThresholdPercentage(60)//熔断器关闭到打开错误比率。默认值：50
                        .withCircuitBreakerSleepWindowInMilliseconds(3000)));//设置在熔断器被打开，拒绝请求到再次尝试请求并决定熔断器是否继续打开的时间。默认值：5000（毫秒）
        this.userService = userService;
        this.userId = userId;
    }

    protected UserInfo run() {
        return userService.getUserInfo(userId);
    }

    @Override
    protected UserInfo getFallback() {
        System.out.println("invoke getFallback...");
        return null;
    }
}
