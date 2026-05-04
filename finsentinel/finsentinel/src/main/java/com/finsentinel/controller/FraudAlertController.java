package com.finsentinel.controller;

import com.finsentinel.alert.FraudAlertService;
import com.finsentinel.model.FraudAlert;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
@RequiredArgsConstructor
public class FraudAlertController {
    private final FraudAlertService alertService;

    @GetMapping("/open")
    public List<FraudAlert> getOpenAlerts(){
        return alertService.getOpenAlerts();
    }

    @PutMapping("/{id}/assign")
    public FraudAlert assign(
            @PathVariable Long id,
            @RequestParam String investigator
    ){
        return alertService.assignAlert(id, investigator);
    }

    @PutMapping("/{id}/status")
    public FraudAlert updateStatus(
            @PathVariable Long id,
            @RequestParam String status
    ){
        return alertService.updateStatus(id, status);
    }
}
