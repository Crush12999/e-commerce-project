package com.sryzzz.ecommerce.service;

import com.sryzzz.ecommerce.common.TableId;
import com.sryzzz.ecommerce.goods.DeductGoodsInventory;
import com.sryzzz.ecommerce.goods.GoodsInfo;
import com.sryzzz.ecommerce.goods.SimpleGoodsInfo;
import com.sryzzz.ecommerce.vo.PageSimpleGoodsInfo;

import java.util.List;

/**
 * @author sryzzz
 * @create 2022/7/25 22:33
 * @description 商品微服务相关服务接口定义
 */
public interface IGoodsService {

    /**
     * 根据 TableId 查询商品详细信息
     *
     * @param tableId 通用 id 对象
     * @return 商品详细信息
     */
    List<GoodsInfo> getGoodsInfoByTableId(TableId tableId);

    /**
     * 获取分页的商品信息
     *
     * @param page 第几页
     * @return 商品信息列表
     */
    PageSimpleGoodsInfo getSimpleGoodsInfoByPage(int page);

    /**
     * 根据 TableId 查询简单商品信息
     *
     * @param tableId 通用 id 对象
     * @return 简单商品信息
     */
    List<SimpleGoodsInfo> getSimpleGoodsInfoByTableId(TableId tableId);

    /**
     * 扣减商品库存
     *
     * @param deductGoodsInventories 扣减商品库存对象列表
     * @return 扣减状态
     */
    Boolean deductGoodsInventory(List<DeductGoodsInventory> deductGoodsInventories);
}
