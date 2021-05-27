package org.example.altinncheckservice.kafka;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.loanprocessinghackathonteam1.buildingblocks.abstractions.AbstractEvent;
import com.loanprocessinghackathonteam1.buildingblocks.financing.CheckOfFinancingNotOK;
import com.loanprocessinghackathonteam1.buildingblocks.financing.CheckOfFinancingOK;
import com.loanprocessinghackathonteam1.buildingblocks.financing.NewCheckOfFinancingEvent;

@Component
@KafkaListener(topics = "${financing.topic.name}")
public class FinancingEventHandler {

    @KafkaHandler
    public void handleCheckOfFinancingOKEvent(@Payload CheckOfFinancingOK event) {
        System.out.println(event);
    }

    @KafkaHandler
    public void handleCheckOfFinancingNotOKEvent(@Payload CheckOfFinancingNotOK event) {
        System.out.println(event);
    }

    @KafkaHandler(isDefault = true)
    public void ignoreEvent(@Payload AbstractEvent event)    {
        System.out.println("Ignored event: " +  event.getEventName());
    }

}
