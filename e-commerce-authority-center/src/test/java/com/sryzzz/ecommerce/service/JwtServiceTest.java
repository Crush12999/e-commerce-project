package com.sryzzz.ecommerce.service;

import cn.hutool.crypto.digest.MD5;
import com.alibaba.fastjson.JSON;
import com.sryzzz.ecommerce.util.TokenParseUtil;
import com.sryzzz.ecommerce.vo.LoginUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author sryzzz
 * @create 2022/7/19 11:38
 * @description Jwt 相关服务测试类
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class JwtServiceTest {

    @Autowired
    private IJwtService jwtService;

    @Test
    public void testGenerateAndParseToken() throws Exception {

        String jwtToken = jwtService.generateToken(
                "admin", "123456"
        );
        log.info("jwt token is: [{}]", jwtToken);

        LoginUserInfo userInfo = TokenParseUtil.parseUserInfoFromToken(jwtToken);
        log.info("parse token: [{}]", JSON.toJSONString(userInfo));
    }
}
