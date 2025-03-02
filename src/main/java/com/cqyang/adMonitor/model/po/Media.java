package com.cqyang.adMonitor.model.po;

import com.cqyang.adMonitor.model.enums.MediaTypeEnum;
import lombok.Data;

@Data
public class Media {

    private Integer id;
    /**
     * 媒体名称
     */
    private String mediaName;
    /**
     * 媒体所属地区
     */
    private String locate;
    /**
     * 注册地址
     */
    private String registerAddress;
    /**
     * 媒体类型
     * @see MediaTypeEnum
     */
    private MediaTypeEnum mediaType;
}
