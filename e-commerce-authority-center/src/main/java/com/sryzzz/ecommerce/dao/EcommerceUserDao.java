package com.sryzzz.ecommerce.dao;

import com.sryzzz.ecommerce.entity.EcommerceUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sryzzz
 * @create 2022/7/18 23:38
 * @description EcommerceUser Dao 接口定义
 */

public interface EcommerceUserDao extends JpaRepository<EcommerceUser, Long> {

    /**
     * 根据用户名查询 EcommerceUser 对象
     * select * from t_ecommerce_user where username = ?
     *
     * @param username 用户名
     * @return EcommerceUser 对象
     */
    EcommerceUser findByUsername(String username);

    /**
     * 根据用户名和密码查询实体对象
     * select * from t_ecommerce_user where username = ? and password = ?
     *
     * @param username 用户名
     * @param password 密码
     * @return 实体对象
     */
    EcommerceUser findByUsernameAndPassword(String username, String password);
}
