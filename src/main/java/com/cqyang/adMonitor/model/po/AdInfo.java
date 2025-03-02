package com.cqyang.adMonitor.model.po;

import com.cqyang.adMonitor.model.enums.AdTagEnum;
import com.cqyang.adMonitor.model.enums.AuditStatusEnum;
import com.cqyang.adMonitor.model.enums.SubmitStatusEnum;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 机审后的广告
 */
@Data
public class AdInfo {

    private Long id;
    /**
     * 原始广告id OriginalAd.id
     */
    private Long originalId;
    /**
     * 审核模版id AuditTemplate.id
     */
    private Integer machineAuditTemplateId;
    /**
     * 广告标题
     */
    private String title;
    /**
     * 广告内容
     */
    private String content;
    /**
     * 媒体id
     */
    private Integer mediaId;
    /**
     * 媒体名称
     */
    private String mediaName;
    /**
     * 广告落地页链接
     */
    private String landingUrl;
    /**
     * 广告详情页链接
     */
    private String detailUrl;
    /**
     * 广告物料链接
     */
    private List<String> materialUrl;
    /**
     * 行业
     */
    private String industry;
    /**
     * 标签
     * @see AdTagEnum
     */
    private AdTagEnum tag;
    /**
     * 业务标记
     */
    private String bizTag;
    /**
     * 机器审核状态
     * @see AuditStatusEnum
     */
    private AuditStatusEnum machineAuditStatus;
    /**
     * 人工初审审核状态
     * @see AuditStatusEnum
     */
    private AuditStatusEnum personTrialStatus;
    /**
     * 人工初审人员名称
     */
    private String personTrialName;
    /**
     * 人工复审审核状态
     * @see AuditStatusEnum
     */
    private AuditStatusEnum personReviewStatus;
    /**
     * 人工复审人员名称
     */
    private String personReviewName;
    /**
     * 交付任务id
     */
    private Long submitTaskId;
    /**
     * 交付状态
     * @see SubmitStatusEnum
     */
    private SubmitStatusEnum submitStatus;
    /**
     * 交付时间
     */
    private LocalDateTime submitTime;
    /**
     * 创建时间=机审完成时间
     */
    private LocalDateTime createTime;
}
