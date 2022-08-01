package com.sryzzz.ecommerce.controller;

import com.sryzzz.ecommerce.service.hystrix.UseHystrixCommandAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sryzzz
 * @create 2022/8/1 23:07
 * @description Hystrix Controller
 */
@Slf4j
@RestController
@RequestMapping("/hystrix")
public class HystrixController {

    @Resource
    private UseHystrixCommandAnnotation useHystrixCommandAnnotation;

    @GetMapping("/hystrix-command-annotation")
    public List<ServiceInstance> getNacosClientInfoUseAnnotation(
            @RequestParam String serviceId) {
        log.info("request nacos client info use annotation: [{}], [{}]",
                serviceId, Thread.currentThread().getName());
        return useHystrixCommandAnnotation.getNacosClientInfo(serviceId);
    }

}
