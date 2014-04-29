package com.home.work.home_expenses.domain;

import java.math.BigDecimal;


/**
 * Created by Bharath on 02-04-2014.
 */
public class IncomeExpenseResponse {

    private BigDecimal income;

    private BigDecimal expense;

    private BigDecimal difference;

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getExpense() {
        return expense;
    }

    public void setExpense(BigDecimal expense) {
        this.expense = expense;
    }

    public BigDecimal getDifference() {
        return difference;
    }

    public void setDifference(BigDecimal difference) {
        this.difference = difference;
    }
}

