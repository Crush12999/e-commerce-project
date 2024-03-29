package com.sryzzz.ecommerce.service.impl;

import com.sryzzz.ecommerce.account.BalanceInfo;
import com.sryzzz.ecommerce.dao.EcommerceBalanceDao;
import com.sryzzz.ecommerce.entity.EcommerceBalance;
import com.sryzzz.ecommerce.filter.AccessContext;
import com.sryzzz.ecommerce.service.IBalanceService;
import com.sryzzz.ecommerce.vo.LoginUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author sryzzz
 * @create 2022/7/23 22:23
 * @description 用于余额相关服务接口实现
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class BalanceServiceImpl implements IBalanceService {

    @Resource
    private EcommerceBalanceDao balanceDao;

    /**
     * 获取当前用户余额信息
     *
     * @return 当前用户余额信息
     */
    @Override
    public BalanceInfo getCurrentUserBalanceInfo() {

        LoginUserInfo loginUserInfo = AccessContext.getLoginUserInfo();
        BalanceInfo balanceInfo = new BalanceInfo(
                loginUserInfo.getId(), 0L
        );

        EcommerceBalance ecommerceBalance = balanceDao.findByUserId(loginUserInfo.getId());
        if (ecommerceBalance != null) {
            balanceInfo.setBalance(ecommerceBalance.getBalance());
        } else {
            // 如果还没有用户余额记录, 这里创建出来，余额设定为0即可
            EcommerceBalance newBalance = new EcommerceBalance();
            newBalance.setUserId(loginUserInfo.getId());
            newBalance.setBalance(0L);
            log.info("init user balance record: [{}]",
                    balanceDao.save(newBalance).getId());
        }

        return balanceInfo;
    }

    /**
     * 扣减用户余额
     *
     * @param balanceInfo 代表想要扣减的余额
     * @return 余额信息
     */
    @Override
    public BalanceInfo deductBalance(BalanceInfo balanceInfo) {

        LoginUserInfo loginUserInfo = AccessContext.getLoginUserInfo();

        if (balanceInfo.getUserId() == null || !balanceInfo.getUserId().equals(loginUserInfo.getId())) {
            throw new RuntimeException("Illegal operation!");
        }

        // 扣减用户余额的一个基本原则: 扣减额 <= 当前用户余额
        EcommerceBalance ecommerceBalance =
                balanceDao.findByUserId(loginUserInfo.getId());
        if (ecommerceBalance == null
                || ecommerceBalance.getBalance() - balanceInfo.getBalance() < 0
        ) {
            throw new RuntimeException("user balance is not enough!");
        }

        Long sourceBalance = ecommerceBalance.getBalance();
        ecommerceBalance.setBalance(ecommerceBalance.getBalance() - balanceInfo.getBalance());
        log.info("deduct balance: [{}], [{}], [{}]",
                balanceDao.save(ecommerceBalance).getId(), sourceBalance,
                balanceInfo.getBalance());

        return new BalanceInfo(
                ecommerceBalance.getUserId(),
                ecommerceBalance.getBalance()
        );
    }
}
