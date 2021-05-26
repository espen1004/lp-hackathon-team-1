package org.example.altinncheckservice.test;

import org.example.altinncheckservice.kafka.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loanprocessinghackathonteam1.buildingblocks.financing.NewCheckOfFinancingEvent;

@RestController
public class TestResource {

    private final MessageProducer messageProducer;

    @Autowired
    public TestResource(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @GetMapping("/test")
    public void generateNewFinanceCheck(@RequestParam String userId, @RequestParam String financeObject, @RequestParam Long amount) {
        NewCheckOfFinancingEvent newCheckOfFinancingEvent = new NewCheckOfFinancingEvent(userId, financeObject, amount);
        messageProducer.publishEvent(newCheckOfFinancingEvent);
    }
}
