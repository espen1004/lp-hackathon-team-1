package com.example.checkoffinancingservice.kafka;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.loanprocessinghackathonteam1.buildingblocks.financing.NewCheckOfFinancingEvent;

@Component
@KafkaListener(topics = "${financing.topic.name}")
public class FinancingEventHandler {

    @KafkaHandler
    public void handleNewCheckOfFinancingEvent(@Payload NewCheckOfFinancingEvent event) {
        System.out.println(event);
    }
}
