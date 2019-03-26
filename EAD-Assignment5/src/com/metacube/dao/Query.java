package com.metacube.dao;

public class Query 
{	

	public static final String search = "select * from user where ";

	

	public static final String getAllUser = "select * from user;";

	

	public static final String updateUser = "update user set first_name = ?, last_name = ?, contact_number  = ?, email  = ? where id = ?;";

	

	public static final String deleteUser = "delete from user where id = ?;";

	

	public static final String insertUser = "insert into user (first_name, last_name, contact_number, email) values(?,?,?,?);";

	

	

}