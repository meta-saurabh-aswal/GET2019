package com.metacube.restfulws.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.metacube.restfulws.controller.CategoryController;
import com.metacube.restfulws.model.Category;
import com.metacube.restfulws.utility.Status;

@Path("/category")
public class CategoryResource 
{
	CategoryController categoryController = new CategoryController();
	
	/*
	 * get all category
	 * @param, authorization String
	 * @return HttpResponse
	 */
	@Path("/getAllCategory")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCategory(@HeaderParam("Authorization") String authorizationString)
	{
		if (!"get-2018".equals(authorizationString)) 
		{			
			return Response.status(401).build();
		}
		
		ArrayList<Category> categoryList=categoryController.getAllCategory();
		System.out.println(categoryList.size());
		Gson gson= new Gson();
		
		if(categoryList.size()>0)
			return Response.ok(gson.toJson(categoryList), MediaType.APPLICATION_JSON).build();
			
			
			return Response.status(404).entity("No Data Available").build();
	
	}
	
	/*
	 * updates category
	 * @param, authorization String
	 * @param,category
	 * @return HttpResponse
	 */
	@PUT
	@Path("/updatecategory")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCategory(@HeaderParam("Authorization") String authorizationString, String category) 
	{
		CategoryController categoryController = new CategoryController();
		
		if (!"get-2018".equals(authorizationString)) 
		{		
			return Response.status(401).build();
		}
		
		Gson gson = new Gson();
		Category category2 = gson.fromJson(category, Category.class);
		Status status = categoryController.updateCategoryName(category2);
		
		if(status == Status.SUCCESS)
			return Response.ok("Success").build();
		if(status == Status.NOTEXISTS)
			return Response.status(Response.Status.NOT_FOUND).entity("Invalid data/Not exists in table").build();
		
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("SQL ERROR").build();
	}
	
	
	
	
	/*
	 * create new category
	 * @param, authorization String
	 * @return HttpResponse
	 */
	@POST
	@Path("/createNewcategory")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createNewcategory(@HeaderParam("Authorization") String authorizationString, String category) 
	{
		CategoryController categoryController = new CategoryController();
		
		if (!"get-2018".equals(authorizationString)) 
		{
			return Response.status(401).build();
		}
		
		Gson gson = new Gson();
		Category category2 = gson.fromJson(category, Category.class);
		Status status = categoryController.createCategory(category2);
		
		if(status == Status.SUCCESS)
			return Response.ok("Success").build();
		
		if(status == Status.FAIL)
			return Response.status(Response.Status.NOT_MODIFIED).entity("FAILED").build();
		
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("SQL ERROR").build();
	}
	
	
	
}