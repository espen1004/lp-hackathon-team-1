package com.example.checkoffinancingservice.financing;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "financing")
public class Financing {

    @Id
    @SequenceGenerator(name="financing_financingId_seq",
            sequenceName="financing_financingId_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="financing_financingId_seq")
    private Long financingId;

    private Long amount;
    private String status;
    private String financeObject;
    private String userId;

    public Financing(Long financingId, Long amount, String status, String financeObject, String userId) {
        this.financingId = financingId;
        this.amount = amount;
        this.status = status;
        this.financeObject = financeObject;
        this.userId = userId;
    }

    public Financing() {
    }

    public Long getFinancingId() {
        return financingId;
    }

    public void setFinancingId(Long financingId) {
        this.financingId = financingId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFinanceObject() {
        return financeObject;
    }

    public void setFinanceObject(String financeObject) {
        this.financeObject = financeObject;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
