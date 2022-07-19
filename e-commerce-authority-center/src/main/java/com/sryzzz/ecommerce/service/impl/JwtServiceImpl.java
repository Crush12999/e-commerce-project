package com.sryzzz.ecommerce.service.impl;

import com.alibaba.fastjson.JSON;
import com.sryzzz.ecommerce.constant.AuthorityConstant;
import com.sryzzz.ecommerce.constant.CommonConstant;
import com.sryzzz.ecommerce.dao.EcommerceUserDao;
import com.sryzzz.ecommerce.entity.EcommerceUser;
import com.sryzzz.ecommerce.service.IJwtService;
import com.sryzzz.ecommerce.vo.LoginUserInfo;
import com.sryzzz.ecommerce.vo.UsernameAndPassword;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Decoder;

import javax.annotation.Resource;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

/**
 * @author sryzzz
 * @create 2022/7/19 11:08
 * @description JWT 相关服务接口实现
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class JwtServiceImpl implements IJwtService {

    @Resource
    private EcommerceUserDao ecommerceUserDao;

    /**
     * 生成 JWT Token，使用默认超时时间
     *
     * @param username 用户名
     * @param password 密码
     * @return Token
     * @throws Exception exception
     */
    @Override
    public String generateToken(String username, String password) throws Exception {
        return generateToken(username, password, 0);
    }

    /**
     * 生成指定超时时间的 Token，单位是天
     *
     * @param username 用户名
     * @param password 密码
     * @param expire   超时时间，单位是天
     * @return Token
     * @throws Exception exception
     */
    @Override
    public String generateToken(String username, String password, int expire) throws Exception {
        // 首先需要验证用户是否能够通过授权校验, 即输入的用户名和密码能否匹配数据表记录
        EcommerceUser ecommerceUser = ecommerceUserDao.findByUsernameAndPassword(username, password);

        if (ecommerceUser == null) {
            log.error("can not find user: [{}], [{}]", username, password);
            return null;
        }

        // Token 中塞入对象, 即 JWT 中存储的信息, 后端拿到这些信息就可以知道是哪个用户在操作
        LoginUserInfo loginUserInfo = new LoginUserInfo(
                ecommerceUser.getId(), ecommerceUser.getUsername()
        );

        if (expire <= 0) {
            expire = AuthorityConstant.DEFAULT_EXPIRE_DAY;
        }

        // 计算超时时间
        ZonedDateTime zdt = LocalDate.now().plus(expire, ChronoUnit.DAYS)
                .atStartOfDay(ZoneId.systemDefault());
        Date expireDate = Date.from(zdt.toInstant());

        return Jwts.builder()
                // jwt payload --> KV
                .claim(CommonConstant.JWT_USER_INFO_KEY, JSON.toJSONString(loginUserInfo))
                // jwt id
                .setId(UUID.randomUUID().toString())
                // jwt 过期时间
                .setExpiration(expireDate)
                // jwt 签名 --> 加密
                .signWith(getPrivateKey(), SignatureAlgorithm.RS256)
                .compact();
    }

    /**
     * 注册用户并生成 Token 返回
     *
     * @param usernameAndPassword 用户名和密码对象
     * @return Token
     * @throws Exception exception
     */
    @Override
    public String registerUserAndGenerateToken(UsernameAndPassword usernameAndPassword) throws Exception {

        // 先去校验用户名是否存在, 如果存在, 不能重复注册
        EcommerceUser oldUser = ecommerceUserDao.findByUsername(usernameAndPassword.getUsername());
        if (oldUser != null) {
            log.error("username is registered: [{}]", oldUser.getUsername());
            return null;
        }

        EcommerceUser ecommerceUser = new EcommerceUser();
        ecommerceUser.setUsername(usernameAndPassword.getUsername());
        // MD5 编码以后
        ecommerceUser.setPassword(usernameAndPassword.getPassword());
        ecommerceUser.setExtraInfo("{}");

        // 注册一个新用户, 写一条记录到数据表中
        ecommerceUser = ecommerceUserDao.save(ecommerceUser);
        log.info("register user success: [{}], [{}]", ecommerceUser.getUsername(),
                ecommerceUser.getId());

        // 生成 token 并返回
        return generateToken(ecommerceUser.getUsername(), ecommerceUser.getPassword());
    }

    /**
     * 根据本地存储的私钥获取到 PrivateKey 对象
     */
    private PrivateKey getPrivateKey() throws Exception {

        PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(
                new BASE64Decoder().decodeBuffer(AuthorityConstant.PRIVATE_KEY));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(priPKCS8);
    }
}
