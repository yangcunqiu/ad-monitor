package com.cqyang.adMonitor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class AdMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdMonitorApplication.class, args);
        log.info("AdMonitorApplication started");
    }
}
