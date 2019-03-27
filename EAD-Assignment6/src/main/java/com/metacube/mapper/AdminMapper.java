package com.metacube.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.model.Admin;

/**
 * Maps the data extracted from database to user object
 *
 */
public class AdminMapper implements RowMapper<Admin>
{
public Admin mapRow(ResultSet rs, int i) throws SQLException
{		
		Admin admin =new Admin(rs.getString(1),rs.getString(2));

		return admin;	
	}
}