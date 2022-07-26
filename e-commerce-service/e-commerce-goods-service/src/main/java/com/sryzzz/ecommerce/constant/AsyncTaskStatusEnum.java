package com.sryzzz.ecommerce.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author sryzzz
 * @create 2022/7/26 22:11
 * @description 异步任务状态枚举
 */
@Getter
@AllArgsConstructor
public enum AsyncTaskStatusEnum {

    /**
     * 执行状态枚举
     */
    STARTED(0, "已经启动"),
    RUNNING(1, "正在运行"),
    SUCCESS(2, "执行成功"),
    FAILED(3, "执行失败"),
    ;

    /**
     * 执行状态编码
     */
    private final int state;

    /**
     * 执行状态描述
     */
    private final String stateInfo;
}
