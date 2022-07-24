package com.sryzzz.ecommerce.constant;

import lombok.Getter;
import lombok.AllArgsConstructor;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author sryzzz
 * @create 2022/7/24 22:32
 * @description 品牌分类
 */
@Getter
@AllArgsConstructor
public enum BrandCategory {

    /**
     * 品牌分类
     */
    BRAND_A("20001", "品牌A"),
    BRAND_B("20002", "品牌B"),
    BRAND_C("20003", "品牌C"),
    BRAND_D("20004", "品牌D"),
    BRAND_E("20005", "品牌E"),
            ;

    /**
     * 品牌分类编码
     */
    private final String code;

    /**
     * 品牌分类描述信息
     */
    private final String description;

    /**
     * 根据 code 获取到 BrandCategory
     */
    public static BrandCategory of(String code) {

        Objects.requireNonNull(code);

        return Stream.of(values())
                .filter(bean -> bean.code.equals(code))
                .findAny()
                .orElseThrow(
                        () -> new IllegalArgumentException(code + " not exists")
                );
    }
}
