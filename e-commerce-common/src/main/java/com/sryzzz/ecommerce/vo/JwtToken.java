package com.sryzzz.ecommerce.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sryzzz
 * @create 2022/7/19 10:59
 * @description 授权中心鉴权之后给客户端的 Token
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtToken {

    /**
     * JWT
     */
    private String token;
}
