package com.example.checkoffinancingservice.kafka;

import com.loanprocessinghackathonteam1.buildingblocks.abstractions.AbstractEvent;

public interface MessageProducer {
    public void publishEvent(AbstractEvent event);
}
