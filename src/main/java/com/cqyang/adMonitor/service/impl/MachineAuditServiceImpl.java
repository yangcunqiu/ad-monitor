package com.cqyang.adMonitor.service.impl;

import com.alibaba.fastjson.JSON;
import com.cqyang.adMonitor.mapper.OriginalAdMapper;
import com.cqyang.adMonitor.model.bo.AuditAdBO;
import com.cqyang.adMonitor.model.po.OriginalAd;
import com.cqyang.adMonitor.service.MachineAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineAuditServiceImpl implements MachineAuditService {

    @Value("${kafka-topic.audit.common-audit}")
    private String commonAuditTopic;

    @Value("${kafka-topic.audit.high-priority-audit}")
    private String highPriorityAuditTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private OriginalAdMapper originalAdMapper;

    @Override
    public void specifiedAdToMachineAudit(List<Long> originalAdIds, String topic) {
        List<OriginalAd> originalAds = originalAdMapper.selectByIds(originalAdIds);

        String auditTopic = Optional.ofNullable(topic).orElse(commonAuditTopic);
        originalAds.forEach(originalAd -> {
            AuditAdBO auditAdBO = new AuditAdBO();
            auditAdBO.setOriginalAdId(originalAd.getId());
            auditAdBO.setTitle(originalAd.getTitle());
            auditAdBO.setContent(originalAd.getContent());
            auditAdBO.setMediaId(originalAd.getMediaId());
            auditAdBO.setMediaName(originalAd.getMediaName());
            auditAdBO.setLandingUrl(originalAd.getLandingUrl());
            auditAdBO.setDetailUrl(originalAd.getDetailUrl());
            auditAdBO.setMaterialUrl(originalAd.getMaterialUrl());
            auditAdBO.setTag(originalAd.getTag());
            auditAdBO.setBizTag(originalAd.getBizTag());
            auditAdBO.setCrawlTime(originalAd.getCrawlTime());
            auditAdBO.setCreateTime(originalAd.getCreateTime());
            kafkaTemplate.send(auditTopic, JSON.toJSONString(auditAdBO));
        });
    }
}
