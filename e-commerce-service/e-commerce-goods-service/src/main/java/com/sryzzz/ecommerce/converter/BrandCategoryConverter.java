package com.sryzzz.ecommerce.converter;

import com.sryzzz.ecommerce.constant.BrandCategory;

import javax.persistence.AttributeConverter;

/**
 * @author sryzzz
 * @create 2022/7/24 22:34
 * @description 品牌分类枚举属性转换器
 */
public class BrandCategoryConverter implements AttributeConverter<BrandCategory, String> {

    @Override
    public String convertToDatabaseColumn(BrandCategory brandCategory) {
        return brandCategory.getCode();
    }

    @Override
    public BrandCategory convertToEntityAttribute(String code) {
        return BrandCategory.of(code);
    }
}
