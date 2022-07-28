package com.sryzzz.ecommerce.service.communication;

import com.alibaba.fastjson.JSON;
import com.sryzzz.ecommerce.constant.CommonConstant;
import com.sryzzz.ecommerce.vo.JwtToken;
import com.sryzzz.ecommerce.vo.UsernameAndPassword;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


/**
 * @author sryzzz
 * @create 2022/7/28 23:02
 * @description 使用 RestTemplate 实现微服务通信
 */
@Slf4j
@Service
public class UseRestTemplateService {

    @Resource
    private LoadBalancerClient loadBalancerClient;

    /**
     * 从授权服务中获取 JwtToken
     */
    public JwtToken getTokenFromAuthorityService(UsernameAndPassword usernameAndPassword) {

        // 第一种方式: 写死 url
        String requestUrl = "http://127.0.0.1:7100/ecommerce-authority-center" +
                "/authority/token";
        log.info("RestTemplate request url and body: [{}], [{}]", requestUrl, JSON.toJSONString(usernameAndPassword));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new RestTemplate().postForObject(
                requestUrl,
                new HttpEntity<>(JSON.toJSONString(usernameAndPassword), headers),
                JwtToken.class
        );
    }

    /**
     * 从授权服务中获取 JwtToken, 且带有负载均衡
     */
    public JwtToken getTokenFromAuthorityServiceWithLoadBalancer(
            UsernameAndPassword usernameAndPassword) {

        // 第二种方式: 通过注册中心拿到服务的信息(是所有的实例), 再去发起调用
        ServiceInstance serviceInstance = loadBalancerClient.choose(
                CommonConstant.AUTHORITY_CENTER_SERVICE_ID
        );
        log.info("Nacos Client Info: [{}], [{}], [{}]",
                serviceInstance.getServiceId(),
                serviceInstance.getInstanceId(),
                JSON.toJSONString(serviceInstance.getMetadata())
        );

        String requestUrl = String.format(
                "http://%s:%s/ecommerce-authority-center/authority/token",
                serviceInstance.getHost(),
                serviceInstance.getPort()
        );
        log.info("login request url and body: [{}], [{}]",
                requestUrl,
                JSON.toJSONString(usernameAndPassword));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new RestTemplate().postForObject(
                requestUrl,
                new HttpEntity<>(JSON.toJSONString(usernameAndPassword), headers),
                JwtToken.class
        );
    }
}
