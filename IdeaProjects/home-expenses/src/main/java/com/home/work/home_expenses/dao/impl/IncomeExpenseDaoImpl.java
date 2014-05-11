package com.home.work.home_expenses.dao.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.home.work.home_expenses.dao.IncomeExpenseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.home.work.home_expenses.domain.IncomeExpenseDetail;
import com.home.work.home_expenses.domain.IncomeExpenseResponse;

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

    @Override
    public void create(final IncomeExpenseDetail incomeExpenseDetail) {
        final String sql =
                "insert into income_and_expense (amount, description, category_name, category_type, "
                        + "transaction_date) values (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, incomeExpenseDetail.getAmount(), incomeExpenseDetail.getDescription(),
                incomeExpenseDetail.getCategoryName(), incomeExpenseDetail.getCategoryType(),
                incomeExpenseDetail.getTransactionDate());
    }

    @Override
    public List<Map<String, Object>> retrieveIncomeAndExpense(final String currentOrPreviousMonth) {

        final String currentMonthDetailSql =
                "select amount, category_type from income_and_expense where " +
                        "(transaction_date between  DATEADD(dd, -DAY(GETDATE()), GETDATE()) AND GETDATE())";
        final String previousMonthDetailSql =
                "select amount, category_type from income_and_expense where " +
                        "(transaction_date between DATEADD(MONTH, DATEDIFF(MONTH, 0, GETDATE())-1, 0) " +
                        "AND DATEADD(MONTH, DATEDIFF(MONTH, -1, GETDATE())-1, -1))";
        final String sql =
                (currentOrPreviousMonth.equalsIgnoreCase("current")) ? currentMonthDetailSql : previousMonthDetailSql;

        return jdbcTemplate.queryForList(sql);
    }

}
