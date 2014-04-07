//package com.home.work.home_expenses.dao;
//
//import com.home.work.home_expenses.domain.IncomeExpenseDetail;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
///**
// * Created by Bharath on 05-04-2014.
// */
//public class IncomeExpenseMapper implements RowMapper<IncomeExpenseDetail> {
//
//    public IncomeExpenseDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
//        IncomeExpenseDetail incomeExpenseDetail = new IncomeExpenseDetail();
//        incomeExpenseDetail.setAmount(rs.getBigDecimal("amount"));
//        incomeExpenseDetail.setAmountType(rs.getString("amount_type"));
//        incomeExpenseDetail.setCategory(rs.getString("category"));
//        incomeExpenseDetail.setDescription(rs.getString("description"));
////        incomeExpenseDetail.setTransactionDate(rs.getDate("transaction_date"));
//        return incomeExpenseDetail;
//    }
//}
