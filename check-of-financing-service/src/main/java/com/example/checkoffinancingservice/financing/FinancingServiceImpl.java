package com.example.checkoffinancingservice.financing;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.checkoffinancingservice.kafka.MessageProducer;

public class FinancingServiceImpl implements FinancingService{
    private final MessageProducer messageProducer;

    @Autowired
    public FinancingServiceImpl(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }
}
