package com.metacube.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.dao.AdminDao;
import com.metacube.model.Admin;

/**
 * It provides service to the controller 
 *
 */

@Service
public class AdminService
{
	@Autowired
	AdminDao adminDao;
	/**
	 * 
	 * @param id
	 * @param password
	 * @return boolean value if admin has correct password, else false
	 */
	public boolean getAdmin(String id, String password)
	{
		List<Admin> adminList = adminDao.getAdmins(id);
		
		for(int i=0;i<adminList.size();i++)
		{
			if(password.equals(adminList.get(i).getPassword()))
				return true;
		}
		
		return false;
		
	}
	
	
}
