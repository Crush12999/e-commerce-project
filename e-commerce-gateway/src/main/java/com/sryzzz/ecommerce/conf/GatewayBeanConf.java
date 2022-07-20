package com.sryzzz.ecommerce.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author sryzzz
 * @create 2022/7/20 12:40
 * @description 网关需要注入到容器中的 Bean
 */
@Configuration
public class GatewayBeanConf {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
