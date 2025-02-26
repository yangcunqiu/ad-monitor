package com.cqyang.adMonitor.service.access;

import com.cqyang.adMonitor.model.po.OriginalAd;

/**
 * 数据接入 所有来源的数据接入都需要实现该接口
 */
public interface DataAccessInterface<T> {


    /**
     * 外部数据 -> OriginalAd
     * 所有外部数据进入系统都必须转成 OriginalAd 类型
     * @param t 外部数据
     * @return 标准原始广告对象
     */
    OriginalAd convert(T t);

}
