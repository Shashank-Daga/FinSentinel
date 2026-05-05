package com.finsentinel.service.monitoring;

import com.finsentinel.event.FraudEvent;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
@RequiredArgsConstructor
public class FraudMonitoringService {
    @Getter
    private final List<FraudEvent> liveEvents = new CopyOnWriteArrayList<>();
    private final SimpMessagingTemplate messagingTemplate;

    @EventListener
    public void handleFraudEvent(FraudEvent event){
        liveEvents.add(0, event);

        if (liveEvents.size() > 100)
            liveEvents.remove(liveEvents.size()-1);

        messagingTemplate.convertAndSend(
                "/topic/fraud",
                event
        );
    }

}
