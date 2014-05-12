package com.home.work.home_expenses;

import com.home.work.home_expenses.dao.IncomeExpenseDao;
import com.home.work.home_expenses.domain.IncomeExpenseDetail;
import com.home.work.home_expenses.domain.IncomeExpenseResponse;

import com.home.work.home_expenses.domain.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Bharath on 28-03-2014.
 */
@Service
@Path("/income-expense")
public class IncomeExpenseService {

    private final IncomeExpenseDao incomeExpenseDao;

    @Autowired
    public IncomeExpenseService(final IncomeExpenseDao incomeExpenseDao) {
        this.incomeExpenseDao = incomeExpenseDao;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add")
    public void addExpense(final IncomeExpenseDetail incomeExpenseDetail) {
        incomeExpenseDao.create(incomeExpenseDetail);
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/retrieve")
    public IncomeExpenseResponse retrieveIncomeAndExpense(final String currentOrPreviousMonth) {

        final List<Map<String, Object>> rows = incomeExpenseDao.retrieveIncomeAndExpense(currentOrPreviousMonth);

        BigDecimal income = new BigDecimal(0);
        BigDecimal expense = new BigDecimal(0);
        for (final Map<String, Object> row : rows) {
            final BigDecimal amount = (BigDecimal) row.get("amount");
            if (((String) row.get("category_type")).equalsIgnoreCase("Income")) {
                income = income.add(amount);
            } else {
                expense = expense.add(amount);
            }
        }

        final IncomeExpenseResponse incomeExpenseResponse = new IncomeExpenseResponse();
        incomeExpenseResponse.setIncome(income);
        incomeExpenseResponse.setExpense(expense);
        incomeExpenseResponse.setDifference(income.subtract(expense));

        return incomeExpenseResponse;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/monthly-report")
    public List<IncomeExpenseDetail> retrieveMonthlyReport(final Period period) {
        return incomeExpenseDao.retrieveMonthlyIncomeAndExpense(period.getMonth(), period.getYear());
    }
}
