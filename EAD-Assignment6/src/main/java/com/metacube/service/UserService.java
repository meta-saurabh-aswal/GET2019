package com.metacube.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.dao.UserDao;
import com.metacube.model.User;


/**
 * It provides service to the controller 
 *
 */

@Service
public class UserService
{

	@Autowired
	private UserDao userDao;
	
	/*
	 * Adds User
	 * @param, user
	 * @return, true if successful  false otherwise
	 */
	public boolean add(User user) 
	{
		return userDao.addUser(user);
	}

	/*
	 *updates user
	 *@param, user
	 *@return,   true if successful  false otherwise
	 */
	public boolean update(User user)
	{
		return userDao.updateUser(user);
	}

	/*
	 *list of all users
	 *@return list of all users 
	 */
	public List<User> getAll() 
	{
		return userDao.getAllUser();
	}

	/*
	 *deletes User
	 *@param, id of user
	 *@return,  true if successful false otherwise
	 */
	public boolean delete(int id)
	{
		return userDao.deleteUser(id);
	}
	
	/*
	 * get user by id
	 * @param, id
	 * @return User, else null
	 */
	public User getUserByID(int id)
	{
		List<User> userList = getAll();
		for(User u : userList)
		{
			if(u.getId() == id)
			{
				return u;
			}
		}
		return null;
	}
	
	/*
	 *Searches user 
	 *@param, type name,email,etc
	 *@param, name of user, email of user, etc
	 *@return list of all users matches the parameter   
	 */
	public List<User> getUser(String type, String value)
	{
		return userDao.getUser(type, value);
	}

}