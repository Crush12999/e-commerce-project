package com.sryzzz.ecommerce.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sryzzz
 * @create 2022/7/18 17:32
 * @description 服务发现
 */
@Slf4j
@Service
public class NacosClientService {

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * <h2>打印 Nacos Client 信息到日志中</h2>
     * */
    public List<ServiceInstance> getNacosClientInfo(String serviceId) {

        // 测试 UseHystrixCommandAnnotation 的超时
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            //
        }

        log.info("request nacos client to get service instance info: [{}]", serviceId);
        return discoveryClient.getInstances(serviceId);
    }
}
