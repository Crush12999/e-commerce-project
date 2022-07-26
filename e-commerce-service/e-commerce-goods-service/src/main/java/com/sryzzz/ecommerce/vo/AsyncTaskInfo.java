package com.sryzzz.ecommerce.vo;

import com.sryzzz.ecommerce.constant.AsyncTaskStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author sryzzz
 * @create 2022/7/25 22:39
 * @description 标记异步任务执行信息
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AsyncTaskInfo {

    /**
     * 异步任务 id
     */
    private String taskId;

    /**
     * 异步任务执行状态
     */
    private AsyncTaskStatusEnum status;

    /**
     * 异步任务开始时间
     */
    private Date startTime;

    /**
     * 异步任务结束时间
     */
    private Date endTime;

    /**
     * 异步任务总耗时
     */
    private String totalTime;
}
