package com.sryzzz.ecommerce.dao;

import com.sryzzz.ecommerce.entity.EcommerceBalance;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sryzzz
 * @create 2022/7/22 19:54
 * @description EcommerceBalance Dao 接口定义
 */
public interface EcommerceBalanceDao extends JpaRepository<EcommerceBalance, Long> {

    /**
     * 根据 userId 查询 EcommerceBalance 对象
     *
     * @param userId 用户id
     * @return EcommerceBalance 对象
     */
    EcommerceBalance findByUserId(Long userId);
}
