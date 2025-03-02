package com.cqyang.adMonitor.model.po;

import com.cqyang.adMonitor.model.enums.ProjectStatusEnum;
import lombok.Data;

@Data
public class Project {

    private Integer id;
    /**
     * 项目名称
     */
    private String projectName;
    /**
     * 项目状态
     * @see ProjectStatusEnum
     */
    private ProjectStatusEnum projectStatus;
    /**
     * 项目所属地区
     */
    private String locate;
}
