package com.sryzzz.ecommerce.dao;

import com.sryzzz.ecommerce.entity.EcommerceAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author sryzzz
 * @create 2022/7/22 19:53
 * @description EcommerceAddress Dao 接口定义
 */
public interface EcommerceAddressDao extends JpaRepository<EcommerceAddress, Long> {

    /**
     * 根据 用户 id 查询地址信息
     *
     * @param userId 用户 id
     * @return 地址信息
     */
    List<EcommerceAddress> findAllByUserId(Long userId);
}
