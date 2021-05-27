package com.example.checkoffinancingservice.financing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.example.checkoffinancingservice.kafka.MessageProducer;
import com.loanprocessinghackathonteam1.buildingblocks.financing.CheckOfFinancingNotOK;
import com.loanprocessinghackathonteam1.buildingblocks.financing.CheckOfFinancingOK;
import com.loanprocessinghackathonteam1.buildingblocks.financing.NewCheckOfFinancingEvent;

@Service
public class FinancingServiceImpl implements FinancingService{
    private final MessageProducer messageProducer;
    private final FinancingRepository financingRepository;
    private final ApplicationEventPublisher eventPublisher;


    @Autowired
    public FinancingServiceImpl(MessageProducer messageProducer, FinancingRepository financingRepository, ApplicationEventPublisher eventPublisher) {
        this.messageProducer = messageProducer;
        this.financingRepository = financingRepository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public List<Financing> getAll() {
        return StreamSupport.stream(financingRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public void handleNewCheckOfFinancingEvent(NewCheckOfFinancingEvent event) {
        Long financingAmount = event.getFinancingAmount();
        Financing financing;
        if(financingAmount < 1000000) {
            financing = new Financing(null, financingAmount, "APPROVED", event.getFinanceObject(), event.getUserId());
            CheckOfFinancingOK checkOfFinancingOKEvent = new CheckOfFinancingOK(event.getUserId(), event.getFinancingAmount().intValue(), event.getFinanceObject());
            messageProducer.publishEventToKafka(checkOfFinancingOKEvent);

        } else if (financingAmount < 10000000) {
            financing = new Financing(null, financingAmount, "MANUAL_CONTROL", event.getFinanceObject(), event.getUserId());

        } else {
            financing = new Financing(null, financingAmount, "DENIED", event.getFinanceObject(), event.getUserId());
            CheckOfFinancingNotOK notOK = new CheckOfFinancingNotOK(event.getUserId(), "Taper", event.getFinanceObject());
            messageProducer.publishEventToKafka(notOK);
        }
        financingRepository.save(financing);
        eventPublisher.publishEvent(financing);
    }
}
