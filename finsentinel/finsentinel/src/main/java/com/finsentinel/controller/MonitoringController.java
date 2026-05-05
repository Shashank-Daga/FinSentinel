package com.finsentinel.controller;

import com.finsentinel.event.FraudEvent;
import com.finsentinel.service.monitoring.FraudMonitoringService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class MonitoringController {
    private final FraudMonitoringService monitoringService;

    @GetMapping("/live")
    public List<FraudEvent> liveFeed(){
        return monitoringService.getLiveEvents();
    }
}
