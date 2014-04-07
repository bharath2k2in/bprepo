package com.home.work.home_expenses.domain;

import com.home.work.home_expenses.deserialize.IncomeExpenseDeserializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Bharath on 28-03-2014.
 */
@JsonDeserialize(using = IncomeExpenseDeserializer.class)
public class IncomeExpenseDetail {

    protected BigDecimal amount;

    protected String description;

    protected String category;

    protected Date transactionDate;

    protected String amountType;

    public IncomeExpenseDetail(BigDecimal amount, String description, String category, Date transactionDate, String amountType) {
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.transactionDate = transactionDate;
        this.amountType = amountType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public String getAmountType() {
        return amountType;
    }

    @Override
    public String toString() {
        return "IncomeExpenseDetail{" +
                "amount=" + amount +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", transactionDate=" + transactionDate +
                ", amountType='" + amountType + '\'' +
                '}';
    }
}
