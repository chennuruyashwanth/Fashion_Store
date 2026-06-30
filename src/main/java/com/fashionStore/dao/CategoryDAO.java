package com.fashionStore.dao;

import java.util.List;
import com.fashionStore.model.Category;

public interface CategoryDAO {

	int addCategory(Category category);

	Category getCategory(int categoryId);

	List<Category> getAllCategories();

	int updateCategory(Category category);

	int deleteCategory(int categoryId);
}