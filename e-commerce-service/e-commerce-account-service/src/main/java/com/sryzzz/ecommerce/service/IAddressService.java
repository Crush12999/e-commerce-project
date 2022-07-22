package com.sryzzz.ecommerce.service;

import com.sryzzz.ecommerce.account.AddressInfo;
import com.sryzzz.ecommerce.common.TableId;

/**
 * @author sryzzz
 * @create 2022/7/22 20:31
 * @description 用户地址相关服务接口定义
 */
public interface IAddressService {

    /**
     * 创建用户地址信息
     *
     * @param addressInfo 地址信息
     * @return 数据表 id
     */
    TableId createAddressInfo(AddressInfo addressInfo);

    /**
     * 获取当前登录的用户地址信息
     *
     * @return 用户地址信息
     */
    AddressInfo getCurrentAddressInfo();

    /**
     * 通过 id 获取用户地址信息
     *
     * @param id EcommerceAddress 表的主键
     * @return 用户地址信息
     */
    AddressInfo getAddressInfoById(Long id);

    /**
     * 通过 TableId 获取用户地址信息
     *
     * @param tableId TableId
     * @return 用户地址信息
     */
    AddressInfo getAddressInfoByTableId(TableId tableId);
}
