package com.metacube.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.model.User;
import com.metacube.service.UserService;


/**
 *Controls the request to perform the operation
 *
 */

@Controller
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private UserService userService;
	
	/**
	 * Maps the request with addUser.jsp page
	 * @return
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String add() 
	{
		return "user/addUser";
	}
	
	/**
	 * Maps the request from addUser.jsp page and add the user in database
	 * @param user
	 * @redirects the page to allUser.jsp
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String add(User user)
	{
		userService.add(user);
		return "redirect:/user/allUser";
	}
	
	/**
	 * Maps the request from allUser to edit the user
	 * @param id
	 * @redirects the page to updateUser.jsp
	 */
	@RequestMapping(value = "/edit/{id}" ,  method = RequestMethod.GET)
	public ModelAndView get(@PathVariable("id") int id)
	{
		User user = userService.getUserByID(id);
		return new ModelAndView("user/updateUser" , "user" , user);
	}
	
	/**
	 * Maps the request from updateUser.jsp to update  which updates the data to database
	 * @param user
	 * @redirects to allUser.jsp
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(User user)
	{
		userService.update(user);
		return "redirect:/user/allUser";
	}
	
	/**
	 * Maps the request to displays list of all user
	 * @redirects to page allUser.jsp which shows the list of Users
	 */
	@RequestMapping(value = "/allUser" , method = RequestMethod.GET)
	public ModelAndView getAll()
	{
		List<User> userList = userService.getAll();
		return new ModelAndView("user/allUser", "users", userList);
	}
	

	/**
	 * Maps the request to delete the user from the database
	 * @param id
	 * @redirects to page allUser.jsp which shows the list of users
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		userService.delete(id);
		return "redirect:/user/allUser";
	}


	/**
	 * To search users by first name
	 * @redirects to searchByName.jsp
	 */
	@RequestMapping(value ="/searchByName", method= RequestMethod.GET)
	public String searchByName()
	{
		return "user/searchByName";
	}
	
	/**
	 * Maps the request to search user by it's first name
	 * @param first name
	 * @redirects to page allUser.jsp 
	 */
	@RequestMapping(value = "/searchUserByFirstName", method = RequestMethod.GET)
	public ModelAndView searchUserByFirstName(@RequestParam("firstName") String firstName)
	{
		List<User> usersList= userService.getUser("firstName", firstName);
		return new ModelAndView("user/allUser","users", usersList) ;
	}
	
	/**
	 * To search users by last name
	 * @redirects to searchlastname.jsp
	 */
	@RequestMapping(value ="/searchByLastName", method= RequestMethod.GET)
	public String searchbylastName()
	{
		return "user/searchLastName";
	}
	
	/**
	 * Maps the request to search user by it's last name
	 * @param last name
	 * @redirects to page allUser.jsp 
	 */
	@RequestMapping(value = "/searchUserByLastName", method = RequestMethod.GET)
	public ModelAndView searchUserByLastName(@RequestParam("lastName") String lastName)
	{
		List<User> usersList= userService.getUser("lastName", lastName);
		return new ModelAndView("user/allUser","users", usersList) ;
	}
	
	
	/**
	 * To search users by contact number
	 * @redirects to searchByNumber.jsp
	 */
	@RequestMapping(value ="/searchBynumber", method= RequestMethod.GET)
	public String searchBynumber()
	{
		return "user/searchByNumber";
	}
	
	
	/**
	 * Maps the request to search user by contact number
	 * @param contact number
	 * @redirects to page allUser.jsp 
	 */
	@RequestMapping(value = "/searchUserByContact", method = RequestMethod.GET)
	public ModelAndView searchUserByContact(@RequestParam("contactNumber") String contactNumber)
	{
		List<User> usersList= userService.getUser("contactNumber", contactNumber);
		return new ModelAndView("user/allUser","users", usersList) ;
	}
	
	
	/**
	 * To search users by email id
	 * @redirects to searchByMail.jsp
	 */
	@RequestMapping(value ="/searchByEmail", method= RequestMethod.GET)
	public String searchByEmail()
	{
		return "user/searchByMail";
	}
	
	
	/**
	 * Maps the request to search user by E-mail id
	 * @param email
	 * @redirects to page allUser.jsp 
	 */
	@RequestMapping(value = "/searchUserByMail", method = RequestMethod.GET)
	public ModelAndView searchUserByMail(@RequestParam("email") String email)
	{
		List<User> usersList= userService.getUser("email", email);
		return new ModelAndView("user/allUser","users", usersList) ;
	}
}