package com.sryzzz.ecommerce.service;

import brave.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author sryzzz
 * @create 2022/7/21 22:16
 * @description 使用代码更直观的看到 Sleuth 生成的相关跟踪信息
 */
@Slf4j
@Service
public class SleuthTraceInfoService {

    /**
     * brave.Tracer 跟踪对象
     */
    @Resource
    private Tracer tracer;

    /**
     * 打印当前的跟踪信息到日志中
     */
    public void logCurrentTraceInfo() {

        log.info("Sleuth trace id: [{}]", tracer.currentSpan().context().traceId());
        log.info("Sleuth span id: [{}]", tracer.currentSpan().context().spanId());
    }

}
