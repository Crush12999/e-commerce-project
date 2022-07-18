package com.sryzzz.ecommerce.controller;

import com.sryzzz.ecommerce.service.NacosClientService;
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
 * @create 2022/7/18 17:34
 * @description nacos client controller
 */
@Slf4j
@RestController
@RequestMapping("/nacos-client")
public class NacosClientController {

    @Resource
    private NacosClientService nacosClientService;

    /**
     * 根据 service id 获取服务所有的实例信息
     *
     * @param serviceId 服务 id
     * @return 这个服务的示例列表
     */
    @GetMapping("/service-instance")
    public List<ServiceInstance> logNacosClientInfo(
            @RequestParam(defaultValue = "e-commerce-nacos-client") String serviceId) {

        log.info("coming in log nacos client info: [{}]", serviceId);
        return nacosClientService.getNacosClientInfo(serviceId);
    }
}
