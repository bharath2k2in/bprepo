package com.home.work.home_expenses;

import com.home.work.home_expenses.dao.income_expense.IncomeExpenseDao;
import com.home.work.home_expenses.domain.IncomeExpenseDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Bharath on 28-03-2014.
 */
@Service
@Path("/expense")
public class IncomeExpenseService {

    private IncomeExpenseDao incomeExpenseDao;

    @Autowired
    public IncomeExpenseService(final IncomeExpenseDao incomeExpenseDao) {
        this.incomeExpenseDao = incomeExpenseDao;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/add")
    public String addExpense(final IncomeExpenseDetail expenseDetail) {
        incomeExpenseDao.create(expenseDetail);
        return new String();
    }
}
