package com.sryzzz.ecommerce.service.communication;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author sryzzz
 * @create 2022/7/29 22:24
 * @description 使用 Ribbon 之前的配置, 增强 RestTemplate
 */
@Component
public class RibbonConfig {

    /**
     * 注入 RestTemplate
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
