package com.sryzzz.ecommerce.constant;

import lombok.Getter;
import lombok.AllArgsConstructor;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author sryzzz
 * @create 2022/7/24 22:35
 * @description 商品类别
 * 电器 -> 手机、电脑
 */
@Getter
@AllArgsConstructor
public enum GoodsCategory {

    /**
     * 商品类别
     */
    DIAN_QI("10001", "电器"),
    JIA_JU("10002", "家具"),
    FU_SHI("10003", "服饰"),
    MY_YIN("10004", "母婴"),
    SHI_PIN("10005", "食品"),
    TU_SHU("10006", "图书"),
    ;

    /**
     * 商品类别编码
     */
    private final String code;

    /**
     * 商品类别描述信息
     */
    private final String description;

    /**
     * 根据 code 获取到 GoodsCategory
     */
    public static GoodsCategory of(String code) {

        Objects.requireNonNull(code);

        return Stream.of(values())
                .filter(bean -> bean.code.equals(code))
                .findAny()
                .orElseThrow(
                        () -> new IllegalArgumentException(code + " not exists")
                );
    }
}
