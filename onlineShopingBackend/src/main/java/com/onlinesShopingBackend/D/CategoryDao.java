package com.onlinesShopingBackend.D;

import java.util.List;

import com.onlinesShopingBackend.model.Category;
public interface CategoryDao {

	public boolean addCategory(Category category);
	public boolean deleteCategory(Category category);
	public boolean updateCategory(Category category);
	
	public Category getcategory(int categoryId);
	public List<Category> listcategories();
	
	
}
