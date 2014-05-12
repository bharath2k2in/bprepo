package com.home.work.home_expenses.dao;

import com.home.work.home_expenses.domain.IncomeExpenseDetail;

import java.util.List;
import java.util.Map;

/**
 * Created by Bharath on 05-04-2014.
 */
public interface IncomeExpenseDao {

    public void create(final IncomeExpenseDetail incomeExpenseDetail);
    
    public List<Map<String, Object>> retrieveIncomeAndExpense(final String currentOrPreviousMonth);

    public List<IncomeExpenseDetail> retrieveMonthlyIncomeAndExpense(final String month, final String year);

}
