package com.sryzzz.ecommerce.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sryzzz
 * @create 2022/7/19 10:58
 * @description 用户名和密码
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsernameAndPassword {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
