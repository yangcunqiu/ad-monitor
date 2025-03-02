package com.cqyang.adMonitor.model.po;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SubmitTask {

    private Integer id;
    /**
     * 交付任务名称
     */
    private String submitTaskName;
    /**
     * 交付任务所属月份
     */
    private LocalDateTime submitTaskMonth;
    /**
     * 交付任务开始时间
     */
    private LocalDateTime submitTaskStartTime;
    /**
     * 交付任务结束时间
     */
    private LocalDateTime submitTaskEndTime;
    /**
     * 交付任务状态
     */
    private Integer submitTaskStatus;
    /**
     * 交付任务所属项目id, ProjectInfo.id
     */
    private Integer projectId;
    /**
     * 交付任务所属项目名称
     */
    private String projectName;

}
