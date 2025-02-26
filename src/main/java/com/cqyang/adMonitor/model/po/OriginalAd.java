package com.cqyang.adMonitor.model.po;

import com.cqyang.adMonitor.model.enums.AdTagEnum;
import com.cqyang.adMonitor.model.enums.SourceTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 原始广告
 */
@Data
public class OriginalAd {

    private Long id;
    /**
     * 来源id
     */
    private Long sourceId;
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
     * 来源类型
     * @see SourceTypeEnum
     */
    private SourceTypeEnum sourceType;

    /**
     * 抓取时间
     */
    private LocalDateTime crawlTime;
    /**
     * 是否机审
     */
    private Boolean isMachineAudit;
    /**
     * 机审时间
     */
    private LocalDateTime MachineAuditTime;
    /**
     * 创建时间=入库时间
     */
    private LocalDateTime createTime;

}
