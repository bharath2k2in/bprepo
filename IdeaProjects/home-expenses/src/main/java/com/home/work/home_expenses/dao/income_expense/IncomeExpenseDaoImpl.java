package com.home.work.home_expenses.dao.income_expense;

import com.home.work.home_expenses.domain.IncomeExpenseDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Bharath on 05-04-2014.
 */
@Repository
public class IncomeExpenseDaoImpl implements IncomeExpenseDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public IncomeExpenseDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(final IncomeExpenseDetail incomeExpenseDetail) {
        final String sql = "insert into income_and_expense (amount, description, category_name, category_type, " +
                "transaction_date) values (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, incomeExpenseDetail.getAmount(), incomeExpenseDetail.getDescription(),
                            incomeExpenseDetail.getCategoryName(), incomeExpenseDetail.getCategoryType(),
                            incomeExpenseDetail.getTransactionDate());
        return;
    }


}
