package com.metacube.restfulws.utility;

public class Query 
{
	public final static String createCategory = "INSERT INTO category VALUES(?,?);";
	
	public final static String getAllCategory = "SELECT * FROM category;";
	
	public final static String getAllAdvertisement = "SELECT * FROM advertisement;";
	
	public final static String getAdvertisementByCategoryID = "SELECT * FROM advertisement WHERE category_id = ?;";
	
	public final static String updateAdvertisementName = "UPDATE advertisement SET advertisement_title = ? WHERE id = ?;";
	
	public final static String updateCategoryName = "UPDATE category SET category_name = ? WHERE id = ?;";
	
	public final static String deleteAdvertisementById = "DELETE FROM advertisement where id = ?;";
	
	public final static String createNewAdvertisement = "INSERT into Advertisement Values(?,?,?,?);";
}
