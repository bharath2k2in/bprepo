package com.home.work.home_expenses;

import com.home.work.home_expenses.dao.IncomeExpenseDao;
import com.home.work.home_expenses.domain.IncomeExpenseDetail;
import com.home.work.home_expenses.domain.IncomeExpenseResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Bharath on 28-03-2014.
 */
@Service
@Path("/income-expense")
public class IncomeExpenseService {

    private IncomeExpenseDao incomeExpenseDao;

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
        return incomeExpenseDao.retrieveIncomeAndExpense(currentOrPreviousMonth);
    }
}
