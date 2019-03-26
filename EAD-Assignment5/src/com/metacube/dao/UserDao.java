package com.metacube.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.mapper.UserMapper;
import com.metacube.model.User;
import com.metacube.dao.Query;


/**

 * UserDao class contains some common method to perform some operations
 *

 */



@Repository

public class UserDao 

{

	//object of jdbcTemplate

	private JdbcTemplate jdbcTemplate;

	

	public UserDao(DataSource dataSource)

	{

		jdbcTemplate = new JdbcTemplate(dataSource);

	}



	//add user to database

	public boolean addUser(User user)

	{

		return jdbcTemplate.update(Query.insertUser, user.getFirstName(), user.getLastName(), user.getContactNumber(), user.getEmail()) > 0;

	}



	//delete user from database

	public boolean deleteUser(int id) 

	{

		return jdbcTemplate.update(Query.deleteUser, id) > 0;

	}



	//update user in database

	public boolean updateUser(User user) 

	{

		return jdbcTemplate.update(Query.updateUser, user.getFirstName(), user.getLastName(), user.getContactNumber(), user.getEmail() , user.getId()) > 0;

	}



	//returns the list of users available in database

	public List<User> getAllUser()

	{

		return jdbcTemplate.query(Query.getAllUser, new UserMapper());

	}

	

	//searches the data from user with respect to given type

	public List<User> search(String type, String value) 

	{

		return jdbcTemplate.query(Query.search+type+" = '"+value+"'", new UserMapper());

	}



}
