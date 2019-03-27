package com.metacube.dao;

public class Query
{	
	public static final String getUser ="Select * from user where";
	
	public static final String getAllUser = "select * from user;";
	
	public static final String updateUser = "update user set firstName = ?, lastName = ?, contactNumber  = ?, email  = ? where id = ?;";
	
	public static final String deleteUser = "delete from user where id = ?;";
	
	public static final String insertUser = "insert into user (firstName, lastName, contactNumber, email) values(?,?,?,?);";
	
	public static final String getAdmin = "Select *  from admin where id ";
}