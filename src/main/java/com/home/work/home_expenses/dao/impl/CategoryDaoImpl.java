package com.home.work.home_expenses.dao.impl;

import com.home.work.home_expenses.dao.CategoryDao;
import com.home.work.home_expenses.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Bharath on 26-04-2014.
 */
@Repository
public class CategoryDaoImpl implements CategoryDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Category> getCategories(final String categoryType) {
        final String sql = "select category_name, category_type from category where category_type = ?";
        return jdbcTemplate.query(sql, new Object[]{categoryType}, new CategoryMapper());
    }

    private class CategoryMapper implements RowMapper<Category> {

        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
            final Category category = new Category();
            category.setCategoryName(rs.getString("category_name"));
            category.setCategoryType(rs.getString("category_type"));
            return category;
        }
    }
}
