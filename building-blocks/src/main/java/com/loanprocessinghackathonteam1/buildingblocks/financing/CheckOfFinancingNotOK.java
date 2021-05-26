package com.loanprocessinghackathonteam1.buildingblocks.financing;

import com.loanprocessinghackathonteam1.buildingblocks.abstractions.AbstractEvent;

public class CheckOfFinancingNotOK extends AbstractEvent {

    private String reason;
    private String financeObject;

    public CheckOfFinancingNotOK(String userId, String reason, String financeObject) {
        super(userId, CheckOfFinancingOK.class.getSimpleName());
        this.reason = reason;
        this.financeObject = financeObject;
    }

    public CheckOfFinancingNotOK() {
        super();
    }

    public String getReason() {
        return reason;
    }

    public CheckOfFinancingNotOK setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public String getFinanceObject() {
        return financeObject;
    }

    public CheckOfFinancingNotOK setFinanceObject(String financeObject) {
        this.financeObject = financeObject;
        return this;
    }

    @Override
    public String toString() {
        return "CheckOfFinancingNotOK{" +
                "reason='" + reason + '\'' +
                ", financeObject=" + financeObject +
                '}';
    }
}
