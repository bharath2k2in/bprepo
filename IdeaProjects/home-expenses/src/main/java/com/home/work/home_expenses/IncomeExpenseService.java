package com.home.work.home_expenses;

import com.home.work.home_expenses.dao.IncomeExpenseDao;
import com.home.work.home_expenses.dao.IncomeExpenseDaoImpl;
import com.home.work.home_expenses.domain.IncomeExpenseDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add")
    public String addExpense(final IncomeExpenseDetail expenseDetail) {
        incomeExpenseDao.create(expenseDetail);
        return new String();
    }
}
