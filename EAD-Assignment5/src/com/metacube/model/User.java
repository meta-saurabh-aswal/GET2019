package com.metacube.model;

/**
 *User class is used as model class to store the details with the following properties
 */

public class User {

	

	private int id;

	private String firstName;

	private String lastName;

	private String contactNumber;

	private String email;



	//returns the id of the user

	public int getId()
	{

		return id;

	}



	//returns the first name of the user

	public String getFirstName()
	{

		return firstName;

	}



	//returns the last name of the user

	public String getLastName()
	{

		return lastName;

	}



	//returns the contact number of the user

	public String getContactNumber()
	{

		return contactNumber;

	}



	//returns the email of the user

	public String getEmail() 
	{

		return email;

	}



	//sets the id of the user

	public void setId(int id) 
	{

		this.id = id;

	}



	//sets the first_name of the user

	public void setFirstName(String firstName)
	{

		this.firstName = firstName;

	}



	//sets the last_name of the user

	public void setLastName(String lastName) 
	{

		this.lastName = lastName;

	}



	//sets the contact_number of the user

	public void setContactNumber(String contactNumber) 
	{

		this.contactNumber = contactNumber;

	}



	//sets the email of the user

	public void setEmail(String email) 
	{

		this.email = email;

	}

}