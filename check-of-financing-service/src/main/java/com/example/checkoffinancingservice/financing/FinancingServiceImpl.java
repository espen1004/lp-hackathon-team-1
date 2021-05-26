package com.example.checkoffinancingservice.financing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.checkoffinancingservice.kafka.MessageProducer;

@Service
public class FinancingServiceImpl implements FinancingService{
    private final MessageProducer messageProducer;
    private final FinancingRepository financingRepository;

    @Autowired
    public FinancingServiceImpl(MessageProducer messageProducer, FinancingRepository financingRepository) {
        this.messageProducer = messageProducer;
        this.financingRepository = financingRepository;
    }

    @Override
    public List<Financing> getAll() {
        return StreamSupport.stream(financingRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
