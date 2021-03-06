package com.example.checkoffinancingservice.financing;

import java.util.List;

import com.loanprocessinghackathonteam1.buildingblocks.financing.NewCheckOfFinancingEvent;

public interface FinancingService {

    List<Financing> getAll();

    void updateFinancing(Long id, String decision);

    void handleNewCheckOfFinancingEvent(NewCheckOfFinancingEvent event);
}
