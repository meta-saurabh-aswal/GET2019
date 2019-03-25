package com.metacube.restfulws.facade;

import java.util.ArrayList;

import com.metacube.restfulws.dao.CategoryDao;
import com.metacube.restfulws.model.Category;
import com.metacube.restfulws.utility.Status;

public class CategoryFacade 
{
	CategoryDao categoryDao= new CategoryDao();
	
	/*
	 * Get all category
	 * @return, list of all category
	 */
	public ArrayList<Category> getAllCategory()
	{
		return categoryDao.getAllCategory();
	}
	
	/*
	 * Create new category
	 * @param, category
	 * @return, Status
	 */
	public Status createCategory(Category newCategory)
	{
		
		return categoryDao.createCategory(newCategory);
	}
	
	/*
	 * Update Category name 
	 * @param, category 
	 * @return, Status
	 */
	public Status updateCategoryName(Category category)
	{
		return categoryDao.updateCategoryName(category.getId(), category.getName());
	}
	
}
