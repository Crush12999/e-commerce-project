package com.sryzzz.ecommerce.converter;

import com.sryzzz.ecommerce.constant.GoodsCategory;

import javax.persistence.AttributeConverter;

/**
 * @author sryzzz
 * @create 2022/7/24 22:38
 * @description 商品类别枚举属性转换器
 */
public class GoodsCategoryConverter implements AttributeConverter<GoodsCategory, String> {

    @Override
    public String convertToDatabaseColumn(GoodsCategory goodsCategory) {
        return goodsCategory.getCode();
    }

    @Override
    public GoodsCategory convertToEntityAttribute(String code) {
        return GoodsCategory.of(code);
    }
}
