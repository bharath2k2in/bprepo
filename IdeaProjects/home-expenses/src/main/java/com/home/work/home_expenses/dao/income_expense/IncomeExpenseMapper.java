package com.home.work.home_expenses.dao.income_expense;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.home.work.home_expenses.domain.IncomeExpenseDetail;

/**
 * Created by Bharath on 05-04-2014.
 */
public class IncomeExpenseMapper implements RowMapper<IncomeExpenseDetail> {

    public IncomeExpenseDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
        IncomeExpenseDetail incomeExpenseDetail = new IncomeExpenseDetail();
        incomeExpenseDetail.setAmount(rs.getBigDecimal("amount"));
        incomeExpenseDetail.setCategoryType(rs.getString("category_type"));
        incomeExpenseDetail.setCategoryName(rs.getString("category_name"));
        incomeExpenseDetail.setDescription(rs.getString("description"));
        incomeExpenseDetail.setTransactionDate(rs.getDate("transaction_date"));
        return incomeExpenseDetail;
    }
}
