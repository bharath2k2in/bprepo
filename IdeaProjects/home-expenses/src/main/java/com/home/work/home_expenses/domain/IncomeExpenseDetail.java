package com.home.work.home_expenses.domain;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Bharath on 28-03-2014.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class IncomeExpenseDetail {

    @XmlAttribute(required = true)
    protected BigDecimal amount;

    @XmlAttribute(required = true)
    protected String description;

    @XmlAttribute(required = true)
    protected String category;

    @XmlAttribute(required = true)
    protected Date transactionDate;

    @XmlAttribute(required = true)
    protected String amountType;

    public IncomeExpenseDetail() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getAmountType() {
        return amountType;
    }

    public void setAmountType(String amountType) {
        this.amountType = amountType;
    }
}
