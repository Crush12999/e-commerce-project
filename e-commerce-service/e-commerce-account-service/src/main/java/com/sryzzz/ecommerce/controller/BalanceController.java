package com.sryzzz.ecommerce.controller;

import com.sryzzz.ecommerce.account.BalanceInfo;
import com.sryzzz.ecommerce.service.IBalanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author sryzzz
 * @create 2022/7/23 22:44
 * @description 用户余额服务 Controller
 */
@Api(tags = "用户余额服务")
@Slf4j
@RestController
@RequestMapping("/balance")
public class BalanceController {

    @Resource
    private IBalanceService balanceService;

    @ApiOperation(value = "当前用户", notes = "获取当前用户余额信息", httpMethod = "GET")
    @GetMapping("/current-balance")
    public BalanceInfo getCurrentUserBalanceInfo() {
        return balanceService.getCurrentUserBalanceInfo();
    }

    @ApiOperation(value = "扣减", notes = "扣减用于余额", httpMethod = "PUT")
    @PutMapping("/deduct-balance")
    public BalanceInfo deductBalance(@RequestBody BalanceInfo balanceInfo) {
        return balanceService.deductBalance(balanceInfo);
    }

}
