package com.home.work.home_expenses;

import com.home.work.home_expenses.domain.ExpenseDetail;
import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Bharath on 28-03-2014.
 */
@Service
@Path("/expense")
public class ExpenseService {

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces(MediaType.APPLICATION_JSON)
    public Response addExpense(final ExpenseDetail expenseDetail) {
        return Response.ok().build();
    }
}
