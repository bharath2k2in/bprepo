package com.home.work.home_expenses.dao.impl;

import com.home.work.home_expenses.dao.IncomeExpenseDao;
import com.home.work.home_expenses.domain.IncomeExpenseDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<IncomeExpenseDetail> retrieveMonthlyIncomeAndExpense(final String month, final String year) {
        final StringBuffer searchCriteria = new StringBuffer();
        searchCriteria.append(year).append("-").append(month).append("-%");

        final String sql = "select * from income_and_expense where transaction_date like ? order by transaction_date";
        return jdbcTemplate.query(sql, new Object[]{searchCriteria.toString()}, new IncomeExpenseDetailMapper());
    }

    private class IncomeExpenseDetailMapper implements RowMapper<IncomeExpenseDetail> {

        public IncomeExpenseDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
            final IncomeExpenseDetail incomeExpenseDetail = new IncomeExpenseDetail();
            incomeExpenseDetail.setTransactionId(rs.getInt("txn_id"));
            incomeExpenseDetail.setAmount(rs.getBigDecimal("amount"));
            incomeExpenseDetail.setDescription(rs.getString("description"));
            incomeExpenseDetail.setTransactionDate(rs.getDate("transaction_date"));
            incomeExpenseDetail.setCategoryName(rs.getString("category_name"));
            incomeExpenseDetail.setCategoryType(rs.getString("category_type"));
            return incomeExpenseDetail;
        }
    }
}
