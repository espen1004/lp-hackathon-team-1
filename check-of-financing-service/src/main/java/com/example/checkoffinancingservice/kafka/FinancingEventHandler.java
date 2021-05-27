package com.example.checkoffinancingservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.example.checkoffinancingservice.financing.FinancingService;
import com.loanprocessinghackathonteam1.buildingblocks.abstractions.AbstractEvent;
import com.loanprocessinghackathonteam1.buildingblocks.financing.CheckOfFinancingNotOK;
import com.loanprocessinghackathonteam1.buildingblocks.financing.CheckOfFinancingOK;
import com.loanprocessinghackathonteam1.buildingblocks.financing.NewCheckOfFinancingEvent;

@Component
@KafkaListener(topics = "${financing.topic.name}")
public class FinancingEventHandler {

    private final FinancingService financingService;

    @Autowired
    public FinancingEventHandler(FinancingService financingService) {
        this.financingService = financingService;
    }
    @KafkaHandler
    public void handleNewCheckOfFinancingEvent(@Payload NewCheckOfFinancingEvent event) {
        financingService.handleNewCheckOfFinancingEvent(event);
    }

    @KafkaHandler(isDefault = true)
    public void ignoreEvent(@Payload AbstractEvent event) {
        System.out.println("Ignored " + event.getEventName());
    }
}
