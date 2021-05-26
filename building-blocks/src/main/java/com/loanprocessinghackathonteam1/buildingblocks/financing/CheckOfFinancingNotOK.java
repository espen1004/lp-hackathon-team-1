package com.loanprocessinghackathonteam1.buildingblocks.financing;

import com.loanprocessinghackathonteam1.buildingblocks.abstractions.AbstractEvent;

public class CheckOfFinancingNotOK extends AbstractEvent {

    private String reason;
    private Long financingId;

    public CheckOfFinancingNotOK(String userId, String reason, Long financingId) {
        super(userId, CheckOfFinancingOK.class.getSimpleName());
        this.reason = reason;
        this.financingId = financingId;
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

    public Long getFinancingId() {
        return financingId;
    }

    public CheckOfFinancingNotOK setFinancingId(Long financingId) {
        this.financingId = financingId;
        return this;
    }

    @Override
    public String toString() {
        return "CheckOfFinancingNotOK{" +
                "reason='" + reason + '\'' +
                ", financingId=" + financingId +
                '}';
    }
}
