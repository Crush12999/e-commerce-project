package com.sryzzz.ecommerce.controller;

import com.sryzzz.ecommerce.service.communication.AuthorityFeignClient;
import com.sryzzz.ecommerce.service.communication.UseFeignApi;
import com.sryzzz.ecommerce.service.communication.UseRestTemplateService;
import com.sryzzz.ecommerce.service.communication.UseRibbonService;
import com.sryzzz.ecommerce.vo.JwtToken;
import com.sryzzz.ecommerce.vo.UsernameAndPassword;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sryzzz
 * @create 2022/7/28 23:14
 * @description 微服务通信 Controller
 */
@RestController
@RequestMapping("/communication")
public class CommunicationController {

    @Resource
    private UseRestTemplateService useRestTemplateService;

    @Resource
    private UseRibbonService useRibbonService;

    @Resource
    private AuthorityFeignClient authorityFeignClient;

    @Resource
    private UseFeignApi useFeignApi;

    @PostMapping("/rest-template")
    public JwtToken getTokenFromAuthorityService(@RequestBody UsernameAndPassword usernameAndPassword) {
        return useRestTemplateService.getTokenFromAuthorityService(usernameAndPassword);
    }

    @PostMapping("/rest-template-load-balancer")
    public JwtToken getTokenFromAuthorityServiceWithLoadBalancer(@RequestBody UsernameAndPassword usernameAndPassword) {
        return useRestTemplateService.getTokenFromAuthorityServiceWithLoadBalancer(
                usernameAndPassword);
    }

    @PostMapping("/ribbon")
    public JwtToken getTokenFromAuthorityServiceByRibbon(
            @RequestBody UsernameAndPassword usernameAndPassword) {
        return useRibbonService.getTokenFromAuthorityServiceByRibbon(usernameAndPassword);
    }

    @PostMapping("/thinking-in-ribbon")
    public JwtToken thinkingInRibbon(@RequestBody UsernameAndPassword usernameAndPassword) {
        return useRibbonService.thinkingInRibbon(usernameAndPassword);
    }

    @PostMapping("/token-by-feign")
    public JwtToken getTokenByFeign(@RequestBody UsernameAndPassword usernameAndPassword) {
        return authorityFeignClient.getTokenByFeign(usernameAndPassword);
    }

    @PostMapping("/thinking-in-feign")
    public JwtToken thinkingInFeign(@RequestBody UsernameAndPassword usernameAndPassword) {
        return useFeignApi.thinkingInFeign(usernameAndPassword);
    }

}
