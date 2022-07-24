package com.sryzzz.ecommerce.converter;

import com.sryzzz.ecommerce.constant.GoodsStatus;

import javax.persistence.AttributeConverter;

/**
 * @author sryzzz
 * @create 2022/7/24 22:29
 * @description 商品状态枚举属性转换器
 */
public class GoodsStatusConverter implements AttributeConverter<GoodsStatus, Integer> {

    /**
     * 转换成可以存入数据表的基本类型
     */
    @Override
    public Integer convertToDatabaseColumn(GoodsStatus goodsStatus) {
        return goodsStatus.getStatus();
    }

    /**
     * 还原数据表中的字段值到 Java 数据类型
     */
    @Override
    public GoodsStatus convertToEntityAttribute(Integer status) {
        return GoodsStatus.of(status);
    }
}
