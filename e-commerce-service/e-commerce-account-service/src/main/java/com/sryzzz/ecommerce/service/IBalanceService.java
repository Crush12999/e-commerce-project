package com.sryzzz.ecommerce.service;

import com.sryzzz.ecommerce.account.BalanceInfo;

/**
 * @author sryzzz
 * @create 2022/7/23 22:22
 * @description 用于余额相关的服务接口定义
 */
public interface IBalanceService {

    /**
     * 获取当前用户余额信息
     *
     * @return 当前用户余额信息
     */
    BalanceInfo getCurrentUserBalanceInfo();

    /**
     * 扣减用户余额
     *
     * @param balanceInfo 代表想要扣减的余额
     * @return 余额信息
     */
    BalanceInfo deductBalance(BalanceInfo balanceInfo);
}
