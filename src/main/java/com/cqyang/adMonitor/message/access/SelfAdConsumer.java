package com.cqyang.adMonitor.message.access;

import com.alibaba.fastjson.JSON;
import com.cqyang.adMonitor.mapper.OriginalAdMapper;
import com.cqyang.adMonitor.model.enums.SourceTypeEnum;
import com.cqyang.adMonitor.model.po.OriginalAd;
import com.cqyang.adMonitor.service.access.DataAccessInterface;
import com.cqyang.adMonitor.service.access.model.SelfAdDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class SelfAdConsumer implements DataAccessInterface<SelfAdDTO> {

    @Autowired
    private OriginalAdMapper originalAdMapper;

    @KafkaListener(groupId = "access", topics = "${kafka-topic.access.self-ad}")
    public void consume(String message) {
        log.info("SelfAdConsumer, receive kafka message : {}", message);
        SelfAdDTO selfAdDTO = JSON.parseObject(message, SelfAdDTO.class);
        OriginalAd originalAd = convert(selfAdDTO);
        originalAdMapper.insert(originalAd);
    }

    @Override
    public OriginalAd convert(SelfAdDTO selfAdDTO) {
        OriginalAd originalAd = new OriginalAd();
        originalAd.setSourceId(selfAdDTO.getSourceId());
        originalAd.setTitle(selfAdDTO.getTitle());
        originalAd.setContent(selfAdDTO.getContent());
        originalAd.setMediaId(selfAdDTO.getMediaId());
        originalAd.setMediaName(selfAdDTO.getMediaName());
        originalAd.setLandingUrl(selfAdDTO.getLandingUrl());
        originalAd.setDetailUrl(selfAdDTO.getDetailUrl());
        originalAd.setMaterialUrl(JSON.toJSONString(selfAdDTO.getMaterialUrl()));
        originalAd.setTag(selfAdDTO.getTag());
        originalAd.setBizTag(selfAdDTO.getBizTag());
        originalAd.setSourceType(SourceTypeEnum.SUPPLIER);
        originalAd.setCrawlTime(selfAdDTO.getCrawlTime());
        originalAd.setIsMachineAudit(Boolean.FALSE);
        originalAd.setCreateTime(LocalDateTime.now());
        return originalAd;
    }
}
