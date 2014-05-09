package com.home.work.home_expenses.dao;

import com.home.work.home_expenses.domain.IncomeExpenseDetail;
import com.home.work.home_expenses.domain.IncomeExpenseResponse;

/**
 * Created by Bharath on 05-04-2014.
 */
public interface IncomeExpenseDao {

    public void create(final IncomeExpenseDetail incomeExpenseDetail);
    
    public IncomeExpenseResponse retrieveIncomeAndExpense(final String currentOrPreviousMonth);

}
