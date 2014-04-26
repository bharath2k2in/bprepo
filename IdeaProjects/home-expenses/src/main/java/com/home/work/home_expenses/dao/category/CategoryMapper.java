package com.home.work.home_expenses.dao.category;

import com.home.work.home_expenses.domain.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Bharath on 26-04-2014.
 */
public class CategoryMapper implements RowMapper<Category> {

    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Category category = new Category();
        category.setCategoryName(rs.getString("category_name"));
        category.setCategoryType(rs.getString("category_type"));
        return category;
    }
}
