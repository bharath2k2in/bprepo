package com.home.work.home_expenses.dao;

import com.home.work.home_expenses.domain.IncomeExpenseDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Bharath on 05-04-2014.
 */
@Component
public class IncomeExpenseDaoImpl implements IncomeExpenseDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public IncomeExpenseDaoImpl(final DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void create(final IncomeExpenseDetail incomeExpenseDetail) {
        String SQL = "insert into income_and_expense (amount, description, category, amount_type, transaction_date) values (?, ?, ?, ?, ?)";

        jdbcTemplate.update(SQL, incomeExpenseDetail.getAmount(), incomeExpenseDetail.getDescription(), incomeExpenseDetail.getCategory(), incomeExpenseDetail.getAmountType(), sdf.format(new Date()));
        System.out.println("Created Record");
        return;
    }
}
