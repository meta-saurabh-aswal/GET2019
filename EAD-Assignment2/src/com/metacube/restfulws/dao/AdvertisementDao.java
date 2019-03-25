package com.metacube.restfulws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.metacube.restfulws.utility.ConnectionToDb;
import com.metacube.restfulws.utility.Query;
import com.metacube.restfulws.utility.Status;

import com.metacube.restfulws.model.Advertisement;
/**
 * Performs the following operations
 * 1. Get all Advertisement
 * 2. Get advertisement by advertisement id
 * 3. Create advertisement
 * 4. Update advertisement
 * 5. Delete advertisement 
 *
 */
public class AdvertisementDao
{

	/**
	 * get all advertisement
	 * @return, list of all advertisement
	 */
	public ArrayList<Advertisement> getAllAdvertisement()
	{
		ArrayList<Advertisement> advertisementList = new ArrayList<Advertisement>();
		
		Connection connection = ConnectionToDb.getConnection();
		
		PreparedStatement pstmt;
		
		ResultSet rs;
		try
		{
			// performs the sql query to get all advertisement
		pstmt= connection.prepareStatement(Query.getAllAdvertisement);
		rs= pstmt.executeQuery();
			while(rs.next())
			{
				Advertisement advertisement= new Advertisement(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				advertisementList.add(advertisement);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return advertisementList;
		
	}
	
	/**
	 * get all advertisement by category id
	 * @param category id
	 * @return list of advertisements
	 */
	public ArrayList<Advertisement> getAdvertisementByCategoryID(int id)
	{
		Connection connection = ConnectionToDb.getConnection();
		ArrayList<Advertisement> advertisementList = new ArrayList<Advertisement>();
		
		PreparedStatement pstmt;
		
		ResultSet rs;
		try
		{
			// performs sql query to get advertisements of same category id
		pstmt= connection.prepareStatement(Query.getAdvertisementByCategoryID);
		pstmt.setInt(1, id);
		rs= pstmt.executeQuery();
			while(rs.next())
			{
				Advertisement advertisement= new Advertisement(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				advertisementList.add(advertisement);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return advertisementList;
	}
	
	
	/**
	 * create new advertisement
	 * @param advertisement
	 * @return Status
	 */
	public Status createAdvertisement(Advertisement advertisement)
	{
		Connection connection = ConnectionToDb.getConnection();
		PreparedStatement pstmt;
		int result;
		try
		{ 
			// executes sql query to create new advertisement
			pstmt=connection.prepareStatement(Query.createNewAdvertisement);
			pstmt.setInt(1,advertisement.getId());
			pstmt.setString(2,advertisement.getTitle());
			pstmt.setString(3,advertisement.getDesc());
			pstmt.setInt(4,advertisement.getCategoryId());
			result=pstmt.executeUpdate();
			if(result>0)
				return Status.SUCCESS;
			else
				return Status.FAIL;
			
		}
		
		catch(Exception e)
		{
			System.out.println(e);
			return Status.ERROR;
		}
	}
	
	/**
	 * Update advertisement name
	 * @param id
	 * @param name
	 * @return Status
	 */
	public Status updateAdvertisement(int id, String name)
	{
		Connection connection = ConnectionToDb.getConnection();
		PreparedStatement pstmt;
		int result;
		
		try
		{
			// executes sql query to  update advertisement name/title
			pstmt=connection.prepareStatement(Query.updateAdvertisementName);
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
	
	/**
	 * delete advertisement by its id
	 * @param id
	 * @return Status
	 */
	public Status deleteAdvertisement(int id)
	{
		Connection connection = ConnectionToDb.getConnection();
		PreparedStatement pstmt;
		int result;
		
		try
		{
			// executes sql query to delete advertisement 
			pstmt=connection.prepareStatement(Query.deleteAdvertisementById);
			pstmt.setInt(1,id);
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
