package com.sryzzz.ecommerce.dao;

import com.sryzzz.ecommerce.constant.BrandCategory;
import com.sryzzz.ecommerce.constant.GoodsCategory;
import com.sryzzz.ecommerce.entity.EcommerceGoods;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * @author sryzzz
 * @create 2022/7/25 21:23
 * @description EcommerceGoods Dao 接口定义
 */
public interface EcommerceGoodsDao extends PagingAndSortingRepository<EcommerceGoods, Long> {

    /**
     * 根据查询条件查询商品表, 并限制返回结果
     * select * from t_ecommerce_goods where goods_category = ? and brand_category = ?
     * and goods_name = ? limit 1;
     *
     * @param goodsCategory 商品类型
     * @param brandCategory 品牌分类
     * @param goodsName     商品名称
     * @return 商品信息
     */
    Optional<EcommerceGoods> findFirst1ByGoodsCategoryAndBrandCategoryAndGoodsName(
            GoodsCategory goodsCategory, BrandCategory brandCategory, String goodsName
    );
}
