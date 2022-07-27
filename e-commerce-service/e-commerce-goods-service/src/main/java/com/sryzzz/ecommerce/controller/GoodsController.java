package com.sryzzz.ecommerce.controller;

import com.sryzzz.ecommerce.common.TableId;
import com.sryzzz.ecommerce.goods.DeductGoodsInventory;
import com.sryzzz.ecommerce.goods.GoodsInfo;
import com.sryzzz.ecommerce.goods.SimpleGoodsInfo;
import com.sryzzz.ecommerce.service.IGoodsService;
import com.sryzzz.ecommerce.vo.PageSimpleGoodsInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sryzzz
 * @create 2022/7/27 20:21
 * @description 商品微服务对外暴露的功能服务 API 接口
 */
@Api(tags = "商品微服务功能接口")
@Slf4j
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private IGoodsService goodsService;

    @ApiOperation(value = "详细商品信息", notes = "根据 TableId 查询详细商品信息", httpMethod = "POST")
    @PostMapping("/goods-info")
    public List<GoodsInfo> getGoodsInfoByTableId(@RequestBody TableId tableId) {
        return goodsService.getGoodsInfoByTableId(tableId);
    }

    @ApiOperation(value = "简单商品信息", notes = "获取分页的简单商品信息", httpMethod = "GET")
    @GetMapping("/page-simple-goods-info")
    public PageSimpleGoodsInfo getSimpleGoodsInfoByPage(
            @RequestParam(required = false, defaultValue = "1") int page) {
        return goodsService.getSimpleGoodsInfoByPage(page);
    }

    @ApiOperation(value = "简单商品信息", notes = "根据 TableId 查询简单商品信息", httpMethod = "POST")
    @PostMapping("/simple-goods-info")
    public List<SimpleGoodsInfo> getSimpleGoodsInfoByTableId(@RequestBody TableId tableId) {
        return goodsService.getSimpleGoodsInfoByTableId(tableId);
    }

    @ApiOperation(value = "扣减商品库存", notes = "扣减商品库存", httpMethod = "PUT")
    @PutMapping("/deduct-goods-inventory")
    public Boolean deductGoodsInventory(
            @RequestBody List<DeductGoodsInventory> deductGoodsInventories) {
        return goodsService.deductGoodsInventory(deductGoodsInventories);
    }
}
