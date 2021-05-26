package com.loanprocessinghackathonteam1.buildingblocks.financing;


import com.loanprocessinghackathonteam1.buildingblocks.abstractions.AbstractEvent;

public class CheckOfFinancingOK extends AbstractEvent {

    private int financingAmount;
    private String financeObject;


    public CheckOfFinancingOK(String userId, int financingAmount, String financeObject) {
        super(userId, CheckOfFinancingOK.class.getSimpleName());
        this.financingAmount = financingAmount;
        this.financeObject = financeObject;
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

    public String getFinanceObject() {
        return financeObject;
    }

    public CheckOfFinancingOK setFinanceObject(String financeObject) {
        this.financeObject = financeObject;
        return this;
    }

    @Override
    public String toString() {
        return "CheckOfFinancingOK{" +
                "financingAmount=" + financingAmount +
                ", financeObject=" + financeObject +
                '}';
    }
}

