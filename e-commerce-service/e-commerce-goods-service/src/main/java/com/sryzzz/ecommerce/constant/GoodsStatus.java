package com.sryzzz.ecommerce.constant;

import lombok.Getter;
import lombok.AllArgsConstructor;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author sryzzz
 * @create 2022/7/24 22:11
 * @description 商品状态枚举类
 */
@Getter
@AllArgsConstructor
public enum GoodsStatus {

    /**
     * 上线
     */
    ONLINE(101, "上线"),
    /**
     * 下线
     */
    OFFLINE(102, "下线"),
    /**
     * 缺货
     */
    STOCK_OUT(103, "缺货"),
    ;

    /**
     * 状态码
     */
    private final Integer status;

    /**
     * 状态描述
     */
    private final String description;

    /**
     * 根据 code 获取到 GoodsStatus
     */
    public static GoodsStatus of(Integer status) {

        Objects.requireNonNull(status);

        return Stream.of(values())
                .filter(bean -> bean.status.equals(status))
                .findAny()
                .orElseThrow(
                        () -> new IllegalArgumentException(status + " not exists")
                );
    }
}
