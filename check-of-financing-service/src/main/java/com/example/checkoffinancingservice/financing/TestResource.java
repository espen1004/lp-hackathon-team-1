package com.example.checkoffinancingservice.financing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResource {

    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public TestResource(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @GetMapping("/test")
    public void test(@RequestParam Long financingId) {
        Financing financing = new Financing(financingId, 5000000L, "APPROVED", "0301-G22/B28", "10024537035");
        eventPublisher.publishEvent(financing);
    }
}
