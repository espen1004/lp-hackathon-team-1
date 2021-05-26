package com.loanprocessinghackathonteam1.buildingblocks.financing;


import com.loanprocessinghackathonteam1.buildingblocks.abstractions.AbstractEvent;

public class CheckOfFinancingOK extends AbstractEvent {

    private int financingAmount;
    private Long financingId;


    public CheckOfFinancingOK(String userId, int financingAmount, Long financingId) {
        super(userId, CheckOfFinancingOK.class.getSimpleName());
        this.financingAmount = financingAmount;
        this.financingId = financingId;
    }

    public CheckOfFinancingOK() {
        super();
    }

    public int getFinancingAmount() {
        return financingAmount;
    }

    public CheckOfFinancingOK setFinancingAmount(int financingAmount) {
        this.financingAmount = financingAmount;
        return this;
    }

    public Long getFinancingId() {
        return financingId;
    }

    public CheckOfFinancingOK setFinancingId(Long financingId) {
        this.financingId = financingId;
        return this;
    }

    @Override
    public String toString() {
        return "CheckOfFinancingOK{" +
                "financingAmount=" + financingAmount +
                ", financingId=" + financingId +
                '}';
    }
}

