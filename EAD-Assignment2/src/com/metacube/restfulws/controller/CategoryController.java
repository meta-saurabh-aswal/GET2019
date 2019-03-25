package com.metacube.restfulws.controller;

import java.util.ArrayList;

import com.metacube.restfulws.facade.CategoryFacade;
import com.metacube.restfulws.model.Category;
import com.metacube.restfulws.utility.Status;

public class CategoryController {
	
	CategoryFacade categoryFacade = new CategoryFacade();
	/*
	 * Get all category
	 * @return, list of all category
	 */
	public ArrayList<Category> getAllCategory()
	{
		return categoryFacade.getAllCategory();
	}
	
	/*
	 * Create new category
	 * @param, category
	 * @return, Status
	 */
	public Status createCategory(Category newCategory)
	{	
		return categoryFacade.createCategory(newCategory);
	}
	
	/*
	 * Update Category name 
	 * @param, category 
	 * @return, Status
	 */
	public Status updateCategoryName(Category category)
	{
		return categoryFacade.updateCategoryName(category);
	}
}
