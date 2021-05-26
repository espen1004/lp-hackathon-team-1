package com.loanprocessinghackathonteam1.buildingblocks.financing;


import com.loanprocessinghackathonteam1.buildingblocks.abstractions.AbstractEvent;

public class NewCheckOfFinancingEvent extends AbstractEvent {

    private String financeObject; //"0301-G20/B100"
    private Long financingAmount;

    public NewCheckOfFinancingEvent() {
    }

    public NewCheckOfFinancingEvent(String userId, String productType, Long financingId) {
        super(userId, NewCheckOfFinancingEvent.class.getName());
        this.financeObject = productType;
        this.financingAmount = financingId;
    }

    public String getFinanceObject() {
        return financeObject;
    }

    public void setFinanceObject(String financeObject) {
        this.financeObject = financeObject;
    }

    public Long getFinancingAmount() {
        return financingAmount;
    }

    public NewCheckOfFinancingEvent setFinancingAmount(Long financingAmount) {
        this.financingAmount = financingAmount;
        return this;
    }

    @Override
    public String toString() {
        return "NewCheckOfFinancingEvent{" +
                "financeObject='" + financeObject + '\'' +
                ", financingAmount=" + financingAmount +
                '}';
    }
}

