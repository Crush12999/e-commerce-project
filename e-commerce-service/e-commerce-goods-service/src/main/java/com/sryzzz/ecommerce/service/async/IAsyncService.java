package com.sryzzz.ecommerce.service.async;

import com.sryzzz.ecommerce.goods.GoodsInfo;

import java.util.List;

/**
 * @author sryzzz
 * @create 2022/7/25 22:37
 * @description 异步服务接口定义
 */
public interface IAsyncService {

    /**
     * 异步将商品信息保存入库
     *
     * @param goodsInfos 商品信息列表
     * @param taskId 异步任务 id
     */
    void asyncImportGoods(List<GoodsInfo> goodsInfos, String taskId);
}
