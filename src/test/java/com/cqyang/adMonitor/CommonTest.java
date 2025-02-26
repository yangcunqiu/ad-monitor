package com.cqyang.adMonitor;

import com.alibaba.fastjson2.JSON;
import com.cqyang.adMonitor.service.access.model.SelfAd;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class CommonTest {

    @Test
    public void testEnum () {
        String str = """
                {"tag":"BAI_DU1"}
                """;

        SelfAd selfAd = JSON.parseObject(str, SelfAd.class);
        log.info(JSON.toJSONString(selfAd));
    }
}
