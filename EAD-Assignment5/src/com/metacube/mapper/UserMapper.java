package com.metacube.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.model.User;

/**
 * Maps the data extracted from database to user object
 */

public class UserMapper implements RowMapper<User>
{

	public User mapRow(ResultSet rs, int i) throws SQLException
	{

		// TODO Auto-generated method stub

		User user =new User();

		user.setId(rs.getInt(1));

		user.setFirstName(rs.getString(2));

		user.setLastName(rs.getString(3));

		user.setContactNumber(rs.getString(4));

		user.setEmail(rs.getString(5));

		return user;	

	}

}