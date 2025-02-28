package com.cqyang.adMonitor.service.access;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

//@Component
@Slf4j
public class SelfAdConsumer {

    @KafkaListener(groupId = "access", topics = "${access.kafka-topic.self-ad}")
    public void consume(String message) {
        log.info("receive kafka message : {}", message);
    }
}
