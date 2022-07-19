package com.sryzzz.ecommerce.controller;

import com.alibaba.fastjson.JSON;
import com.sryzzz.ecommerce.annotation.IgnoreResponseAdvice;
import com.sryzzz.ecommerce.service.IJwtService;
import com.sryzzz.ecommerce.vo.JwtToken;
import com.sryzzz.ecommerce.vo.UsernameAndPassword;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sryzzz
 * @create 2022/7/19 11:22
 * @description 对外暴露的授权服务接口
 */
@Slf4j
@RestController
@RequestMapping("/authority")
public class AuthorityController {

    @Resource
    private IJwtService iJwtService;

    /**
     * 从授权中心获取 Token (其实就是登录功能), 且返回信息中没有统一响应的包装
     */
    @IgnoreResponseAdvice
    @PostMapping("/token")
    public JwtToken token(@RequestBody UsernameAndPassword usernameAndPassword) throws Exception {

        log.info("request to get token with param: [{}]",
                JSON.toJSONString(usernameAndPassword));
        return new JwtToken(iJwtService.generateToken(
                usernameAndPassword.getUsername(),
                usernameAndPassword.getPassword()
        ));
    }

    /**
     * 注册用户并返回当前注册用户的 Token, 即通过授权中心创建用户
     *
     * @param usernameAndPassword 用户名和密码
     * @return Token
     */
    @IgnoreResponseAdvice
    @PostMapping("/register")
    public JwtToken register(@RequestBody UsernameAndPassword usernameAndPassword) throws Exception {

        log.info("register user with param: [{}]", JSON.toJSONString(usernameAndPassword));

        return new JwtToken(iJwtService.registerUserAndGenerateToken(usernameAndPassword));
    }
}
