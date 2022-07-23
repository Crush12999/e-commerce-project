package com.sryzzz.ecommerce.service;

import com.alibaba.fastjson.JSON;
import com.sryzzz.ecommerce.account.BalanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sryzzz
 * @create 2022/7/23 22:33
 * @description 用户约相关服务测试
 */
@Slf4j
public class BalanceServiceTest extends BaseTest {

    @Autowired
    private IBalanceService balanceService;

    /**
     * 测试获取当前用户的余额信息
     */
    @Test
    public void testGetCurrentUserBalanceInfo() {
        log.info("test get current user balance info: [{}]", JSON.toJSONString(
                balanceService.getCurrentUserBalanceInfo()
        ));
    }

    /**
     * 测试扣减用于余额
     */
    @Test
    public void testDeductBalance() {

        BalanceInfo balanceInfo = new BalanceInfo();
        balanceInfo.setUserId(loginUserInfo.getId());
        balanceInfo.setBalance(1000L);

        log.info("test deduct balance: [{}]", JSON.toJSONString(
                balanceService.deductBalance(balanceInfo)
        ));
    }

}
