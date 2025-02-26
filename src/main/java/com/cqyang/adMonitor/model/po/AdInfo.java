package com.cqyang.adMonitor.model.po;

import com.cqyang.adMonitor.model.enums.AdTagEnum;
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
     * 标签
     * @see AdTagEnum
     */
    private AdTagEnum tag;
    /**
     * 批次
     */
    private String batch;
    /**
     * 机器审核状态
     */
    private Integer machineAuditStatus;
    /**
     * 人工初审审核状态
     */
    private Integer personTrialStatus;
    /**
     * 人工初审人员名称
     */
    private Integer personTrialName;
    /**
     * 人工复审审核状态
     */
    private Integer personReviewStatus;
    /**
     * 人工复审人员名称
     */
    private Integer personReviewName;
    /**
     * 交付状态
     */
    private Integer submitStatus;
    /**
     * 创建时间=机审完成时间
     */
    private LocalDateTime createTime;
}
