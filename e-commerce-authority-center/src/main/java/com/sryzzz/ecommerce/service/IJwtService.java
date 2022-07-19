package com.sryzzz.ecommerce.service;

import com.sryzzz.ecommerce.vo.UsernameAndPassword;

/**
 * @author sryzzz
 * @create 2022/7/19 11:03
 * @description JWT 相关服务接口定义
 */
public interface IJwtService {

    /**
     * 生成 JWT Token，使用默认超时时间
     *
     * @param username 用户名
     * @param password 密码
     * @return Token
     * @throws Exception exception
     */
    String generateToken(String username, String password) throws Exception;

    /**
     * 生成指定超时时间的 Token，单位是天
     *
     * @param username 用户名
     * @param password 密码
     * @param expire 超时时间，单位是天
     * @return Token
     * @throws Exception exception
     */
    String generateToken(String username, String password, int expire) throws Exception;

    /**
     * 注册用户并生成 Token 返回
     * @param usernameAndPassword 用户名和密码对象
     * @return Token
     * @throws Exception exception
     */
    String registerUserAndGenerateToken(UsernameAndPassword usernameAndPassword)
            throws Exception;
}
