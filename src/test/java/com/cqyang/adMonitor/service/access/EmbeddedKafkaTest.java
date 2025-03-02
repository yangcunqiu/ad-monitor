package com.cqyang.adMonitor.service.access;

import com.alibaba.fastjson.JSON;
import com.cqyang.adMonitor.model.enums.AdTagEnum;
import com.cqyang.adMonitor.service.access.model.SelfAdDTO;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;

import java.time.LocalDateTime;

@SpringBootTest
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
public class EmbeddedKafkaTest {

    @Value("${kafka-topic.access.self-ad}")
    private String selfAdTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    public void testSend() {
        SelfAdDTO selfAdDTO = new SelfAdDTO();
        selfAdDTO.setSourceId("ibqwdqiwdwqidci");
        selfAdDTO.setTitle("测试刚刚");
        selfAdDTO.setContent("通过以上简单操作，就能对 user 表进行 CRUD 操作，不需要去编写 xml 文件");
        selfAdDTO.setMediaId(1);
        selfAdDTO.setMediaName("抖音");
        selfAdDTO.setLandingUrl("https://blog.csdn.net/ju_362204801/article/details/105174054");
        selfAdDTO.setDetailUrl("https://blog.csdn.net/ju_362204801/article/details/105174054");
        selfAdDTO.setMaterialUrl(Lists.newArrayList("https://blog.csdn.net/ju_362204801/article/details/105174054"));
        selfAdDTO.setTag(AdTagEnum.BAI_DU);
        selfAdDTO.setBizTag("test_biz");
        selfAdDTO.setCrawlTime(LocalDateTime.now());
        kafkaTemplate.send(selfAdTopic, JSON.toJSONString(selfAdDTO));

        while (true){}
    }
}
