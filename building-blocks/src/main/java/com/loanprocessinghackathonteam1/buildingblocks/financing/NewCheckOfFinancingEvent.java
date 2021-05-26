package com.loanprocessinghackathonteam1.buildingblocks.financing;


import com.loanprocessinghackathonteam1.buildingblocks.abstractions.AbstractEvent;

public class NewCheckOfFinancingEvent extends AbstractEvent {

    private String productType;
    private Long financingId;

    public NewCheckOfFinancingEvent() {
    }

    public NewCheckOfFinancingEvent(String productType, String userId, Long financingId) {
        super(userId, NewCheckOfFinancingEvent.class.getName());
        this.productType = productType;
        this.financingId = financingId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }


    public Long getFinancingId() {
        return financingId;
    }

    public NewCheckOfFinancingEvent setFinancingId(Long financingId) {
        this.financingId = financingId;
        return this;
    }

    @Override
    public String toString() {
        return "NewCheckOfFinancingEvent{" +
                "productType='" + productType + '\'' +
                ", financingId=" + financingId +
                '}';
    }
}

