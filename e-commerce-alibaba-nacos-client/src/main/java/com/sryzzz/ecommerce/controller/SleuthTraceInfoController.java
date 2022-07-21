package com.sryzzz.ecommerce.controller;

import com.sryzzz.ecommerce.service.SleuthTraceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sryzzz
 * @create 2022/7/21 22:19
 * @description 打印跟踪信息
 */
@Slf4j
@RestController
@RequestMapping("/sleuth")
public class SleuthTraceInfoController {

    @Resource
    private SleuthTraceInfoService traceInfoService;

    /**
     * 打印日志跟踪信息
     */
    @GetMapping("/trace-info")
    public void logCurrentTraceInfo() {
        traceInfoService.logCurrentTraceInfo();
    }
}
