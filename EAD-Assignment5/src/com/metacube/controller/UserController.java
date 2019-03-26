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

 * UserController class controls the request to perform the operation

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

	 * To search the list of user from the database

	 * @param type which can be first_name , last_name , etc.

	 * @param value which is to be searched for from the database

	 * @redirects to page which shows the list of searched user

	 */

	@RequestMapping(value = "/search" , method = RequestMethod.GET)

	public ModelAndView search(@RequestParam("type") String type, @RequestParam("value") String value)

	{

		List<User> userList = userService.search(type, value);

		return new ModelAndView("user/allUser", "users", userList);

	}

}
