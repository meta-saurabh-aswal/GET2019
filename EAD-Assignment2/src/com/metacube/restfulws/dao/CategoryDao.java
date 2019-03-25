package com.metacube.restfulws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.metacube.restfulws.model.Category;
import com.metacube.restfulws.utility.ConnectionToDb;
import com.metacube.restfulws.utility.Query;
import com.metacube.restfulws.utility.Status;


public class CategoryDao {

	/*
	 * Get all category
	 * @return, list of all category
	 */
	public ArrayList<Category> getAllCategory()
	{
		ArrayList<Category> categoryList = new ArrayList<Category>();

		Connection connection = ConnectionToDb.getConnection();

		PreparedStatement pstmt;

		ResultSet rs;
		try
		{
			// executes sql query to get list of all category
			pstmt= connection.prepareStatement(Query.getAllCategory);
			rs= pstmt.executeQuery();

			while(rs.next())
			{
				Category category= new Category(rs.getInt(1), rs.getString(2));
				categoryList.add(category);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		return categoryList;
	}

	/*
	 * Create new category
	 * @param, category
	 * @return, Status
	 */
	public Status createCategory(Category category)
	{
		Connection connection = ConnectionToDb.getConnection();

		PreparedStatement pstmt;

		int result;
		try
		{
			// executes sql query to create new category
			pstmt= connection.prepareStatement(Query.createCategory);

			pstmt.setInt(1, category.getId());
			pstmt.setString(2, category.getName());
			result=pstmt.executeUpdate();

			if(result>0)
				return Status.SUCCESS;
			if(result==0)
				return Status.FAIL;

			return Status.FAIL;
		}

		catch(Exception e)
		{
			System.out.println(e);
			return Status.ERROR;
		}

	}

	/*
	 * Update Category name 
	 * @param, category 
	 * @return, Status
	 */
	public Status updateCategoryName(int id ,String name)
	{
		Connection connection = ConnectionToDb.getConnection();
		PreparedStatement pstmt;
		int result;

		try
		{
			// executes sql query to update category name
			pstmt=connection.prepareStatement(Query.updateCategoryName);

			pstmt.setString(1,name);
			pstmt.setInt(2,id);
			result=pstmt.executeUpdate();

			if(result>0)
				return Status.SUCCESS;
			else
				return Status.NOTEXISTS;

		}

		catch(Exception e)
		{
			System.out.println(e);
			return Status.ERROR;
		}
	}



}
