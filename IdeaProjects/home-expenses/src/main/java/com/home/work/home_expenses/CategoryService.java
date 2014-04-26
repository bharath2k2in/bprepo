package com.home.work.home_expenses;

import com.home.work.home_expenses.dao.category.CategoryDao;
import com.home.work.home_expenses.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Bharath on 26-04-2014.
 */
@Service
@Path("/category")
public class CategoryService {

    private CategoryDao categoryDao;

    @Autowired
    public CategoryService(final CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public List<Category> getCategories(final String categoryType) {

        final List<Category> categories = categoryDao.getCategories(categoryType);
        return categories;
    }
}
