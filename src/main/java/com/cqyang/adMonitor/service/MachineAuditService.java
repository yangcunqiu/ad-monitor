package com.cqyang.adMonitor.service;

import java.util.List;

public interface MachineAuditService {

    void specifiedAdToMachineAudit(List<Long> originalAdIds, String topic);
}
