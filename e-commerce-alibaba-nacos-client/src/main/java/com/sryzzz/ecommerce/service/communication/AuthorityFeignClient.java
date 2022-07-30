package com.sryzzz.ecommerce.service.communication;

import com.sryzzz.ecommerce.vo.JwtToken;
import com.sryzzz.ecommerce.vo.UsernameAndPassword;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author sryzzz
 * @create 2022/7/30 22:13
 * @description 与 Authority 服务通信的 Feign Client 接口定义
 */
@FeignClient(contextId = "AuthorityFeignClient", value = "e-commerce-authority-center")
public interface AuthorityFeignClient {

    /**
     * 通过 OpenFeign 访问 Authority 获取 Token
     *
     * @param usernameAndPassword 用户名、密码
     * @return Token
     */
    @RequestMapping(value = "/ecommerce-authority-center/authority/token",
            method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    JwtToken getTokenByFeign(@RequestBody UsernameAndPassword usernameAndPassword);
}
