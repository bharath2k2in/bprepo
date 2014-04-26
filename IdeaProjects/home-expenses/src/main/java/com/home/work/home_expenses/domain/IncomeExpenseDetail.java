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

    public IncomeExpenseDetail(BigDecimal amount, String description, String categoryName, Date transactionDate, String categoryType) {
        this.amount = amount;
        this.description = description;
        this.categoryName = categoryName;
        this.transactionDate = transactionDate;
        this.categoryType = categoryType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public String getCategoryType() {
        return categoryType;
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
