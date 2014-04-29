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

    protected String categoryName;

    protected Date transactionDate;

    protected String categoryType;

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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    @Override
    public String toString() {
        return "IncomeExpenseDetail{" +
                "amount=" + amount +
                ", description='" + description + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", transactionDate=" + transactionDate +
                ", categoryType='" + categoryType + '\'' +
                '}';
    }
}
