package com.cqyang.adMonitor.service.access.model;

import com.cqyang.adMonitor.model.enums.AdTagEnum;
import lombok.Data;

import java.util.List;

@Data
public class SelfAd {

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
}
