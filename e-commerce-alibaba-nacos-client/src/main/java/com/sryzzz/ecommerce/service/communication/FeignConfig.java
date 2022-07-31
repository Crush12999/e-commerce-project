package com.sryzzz.ecommerce.service.communication;

import feign.Logger;
import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author sryzzz
 * @create 2022/7/31 22:22
 * @description OpenFeign 配置类
 */
@Configuration
public class FeignConfig {

    /**
     * 连接超时时间
     */
    public static final int CONNECT_TIMEOUT_MILLS = 5000;

    /**
     * 读取响应结果超时时间
     */
    public static final int READ_TIMEOUT_MILLS = 5000;

    /**
     * 开启 OpenFeign 日志
     */
    @Bean
    public Logger.Level feignLogger() {
        // 需要注意, 日志级别需要修改成 debug
        return Logger.Level.FULL;
    }

    /**
     * OpenFeign 开启重试
     * period = 100 发起当前请求的时间间隔, 单位是 ms
     * maxPeriod = 1000 发起当前请求的最大时间间隔, 单位是 ms
     * maxAttempts = 5 最多请求次数
     */
    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(
                100,
                SECONDS.toMillis(1),
                5
        );
    }

    /**
     * 对请求的连接和响应时间进行限制
     */
    @Bean
    public Request.Options options() {
        return new Request.Options(
                CONNECT_TIMEOUT_MILLS, TimeUnit.MICROSECONDS,
                READ_TIMEOUT_MILLS, TimeUnit.MILLISECONDS,
                true
        );
    }
}
