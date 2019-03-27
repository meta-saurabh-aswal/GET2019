package com.metacube.model;

/**
 * User with basic details like
 * id
 * First Name
 * Last Name
 * Contact Number
 * E-Mail
 *
 */
public class User
{
	private int id;
	private String firstName;
	private String lastName;
	private String contactNumber;
	private String email;

	public int getId() {
		return id;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}