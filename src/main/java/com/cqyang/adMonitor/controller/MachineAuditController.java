package com.cqyang.adMonitor.controller;

import com.cqyang.adMonitor.model.vo.Result;
import com.cqyang.adMonitor.service.MachineAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/machineAudit")
public class MachineAuditController {

    @Autowired
    private MachineAuditService machineAuditService;

    /**
     * 指定广告送审
     * @param originalAdIds 原始广告id
     * @return Result
     */
    @GetMapping("/specifiedAdToMachineAudit")
    public Result<Void> specifiedAdToMachineAudit(@RequestParam("originalAdIds") List<Long> originalAdIds, @RequestParam(value = "topic", required = false) String topic) {
        machineAuditService.specifiedAdToMachineAudit(originalAdIds, topic);
        return Result.success();
    }
}
