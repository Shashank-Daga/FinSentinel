package com.finsentinel.stream;

import com.finsentinel.model.FraudAlert;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FraudAlertListener {
    private final SimpMessagingTemplate messagingTemplate;

    @EventListener
    public void listen(FraudAlert alert){
        messagingTemplate.convertAndSend(
                "/topic/fraud",
                alert
        );
    }
}
