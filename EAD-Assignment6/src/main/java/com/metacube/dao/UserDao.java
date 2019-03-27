package com.metacube.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.mapper.UserMapper;
import com.metacube.model.User;

/**
 *It implements the interface UserDao
 *  which contains some method to perform some operations
 *
 */

@Repository
public class UserDao
{	
	private JdbcTemplate jdbcTemplate;
	
	
	public UserDao(DataSource dataSource)
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/*
	 * Adds User
	 * @param, user
	 * @return, true if successful false otherwise
	 */
	public boolean addUser(User user)
	{
		return jdbcTemplate.update(Query.insertUser, user.getFirstName(), user.getLastName(), 
					   user.getContactNumber(), user.getEmail()) > 0;
	}

	/*
	 *deletes User
	 *@param, id of user
	 *@return,  true if successful false otherwise
	 */
	public boolean deleteUser(int id) 
	{
		return jdbcTemplate.update(Query.deleteUser, id) > 0;
	}

	/*
	 *updates user
	 *@param, user
	 *@return,   true if successful false otherwise
	 */
	public boolean updateUser(User user) 
	{
		return jdbcTemplate.update(Query.updateUser, user.getFirstName(), user.getLastName(),
					   user.getContactNumber(), user.getEmail(), user.getId()) > 0;
	}
	
	
	/*
	 *list of all users
	 *@return list of all users 
	 */
	public List<User> getAllUser()
	{
		return jdbcTemplate.query(Query.getAllUser, new UserMapper());
	}
	
	/*
	 *Searches user 
	 *@param, type name,email,etc
	 *@param, name of user, email of user, etc
	 *@return list of all users matches the parameter   
	 */
	public List<User> getUser(String type,String value)
	{
		return jdbcTemplate.query(Query.getUser+" "+type+" = '"+value+"'", new UserMapper());
	} 
}