package com.cqyang.adMonitor.message.audit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AdMachineAuditConsumer {

    @KafkaListener(groupId = "audit", topics = "${kafka-topic.audit.common-audit}")
    public void consume(String message) {
        log.info("AdMachineAuditConsumer.consume, receive kafka message : {}", message);

    }

    @KafkaListener(groupId = "audit", topics = "${kafka-topic.audit.high-priority-audit}")
    public void highPriorityConsume(String message) {

    }
}
