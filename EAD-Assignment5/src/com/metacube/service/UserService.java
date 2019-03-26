package com.metacube.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.dao.UserDao;

import com.metacube.model.User;

import com.metacube.service.UserService;

/**
 * UserService provides service to the controller layer of the application which uses the object of UserDao
 */

@Service
public class UserService 

{
	//object of UserDao layer to perform the operations

	@Autowired

	private UserDao userDao;



	//adding the user passed in the parameter to the database

	public boolean add(User user) 

	{

		return userDao.addUser(user);

	}



	//updating the user passed in the parameter in the database

	public boolean update(User user)

	{

		return userDao.updateUser(user);

	}



	//returns the list of the users from the database

	public List<User> getAll() 

	{

		return userDao.getAllUser();

	}



	//deletes the user of given user id from the database

	public boolean delete(int id)

	{

		return userDao.deleteUser(id);

	}

	

	//returns the reference of the user of given user id from the database

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



	//performs the search operation with reference to type given and searches for the value given

	public List<User> search(String type, String value) 

	{

		return userDao.search(type, value);

	}

	

}