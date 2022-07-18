package com.sryzzz.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author sryzzz
 * @create 2022/7/18 23:20
 * @description 授权中心启动入口
 */
@EnableJpaAuditing
@EnableDiscoveryClient
@SpringBootApplication
public class AuthorityCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthorityCenterApplication.class, args);
    }
}
