package com.home.work.home_expenses.dao.category;

import com.home.work.home_expenses.domain.Category;

import java.util.List;

/**
 * Created by Bharath on 26-04-2014.
 */
public interface CategoryDao {

    public List<Category> getCategories(final String categoryType);
}
