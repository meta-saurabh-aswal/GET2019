package com.metacube.restfulws.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.metacube.restfulws.utility.Status;

import com.google.gson.*;
import com.metacube.restfulws.controller.AdvertisementController;
import com.metacube.restfulws.model.Advertisement;
/**
 * Performs the following operations
 * 1. Get all Advertisement
 * 2. Get advertisement by advertisement id
 * 3. Create advertisement
 * 4. Update advertisement
 * 5. Delete advertisement 
 *
 */

@Path("/advertise")
public class AdvertisementResource 
{

	AdvertisementController advertisementController= new AdvertisementController();
	/*
	 * get all the advertisement
	 * @param, authorization String
	 * @return, HttpResponse  
	 */
	@Path("/getAllAdvertisement")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAdvertisement(@HeaderParam("Authorization") String authorizationString)
	{
		if (!"get-2018".equals(authorizationString)) {
			
			return Response.status(401).build();
		}
		ArrayList<Advertisement> advertisementList=advertisementController.getAllAdvertisement();
		Gson gson= new Gson();
		if(advertisementList.size()>0)
		return Response.ok(gson.toJson(advertisementList), MediaType.APPLICATION_JSON).build();
		
		
		return Response.status(404).entity("No Data Available").build();
	}
	
	
	/*
	 * get all the advertisement by category id
	 * @param, authorization String
	 * @param, id
	 * @return, HttpResponse  
	 */
	@Path("/getAdvertisementByCategoryID/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAdvertisementByCategoryID(@HeaderParam("Authorization") String authorizationString, @PathParam("id") int id)
	{	
		if (!"get-2018".equals(authorizationString)) {
			
			return Response.status(401).build();
		}
		Gson gson= new Gson();
		ArrayList<Advertisement> advertisementList=advertisementController.getAdvertisementByCategoryID(id);
		System.out.println(advertisementList.size());
		if(advertisementList.size()>0)
			return Response.ok(gson.toJson(advertisementList), MediaType.APPLICATION_JSON).build();
			
			
			return Response.status(404).entity("No Data Available").build();
	}
	
	
	
	/*
	 * create new advertisement
	 * @param, authorization String
	 * @param, advertisement
	 * @return, HttpResponse
	 */
	@Path("/createNewAdvertisement")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createNewcategory(@HeaderParam("Authorization") String authorizationString,  String advertisement) 
	{
		if (!"get-2018".equals(authorizationString)) {
		
			return Response.status(401).build();
		}
		Gson gson = new Gson();
		Advertisement advertisement2 = gson.fromJson(advertisement, Advertisement.class);
		Status status = advertisementController.createAdvertisement(advertisement2);
		
		if(status == Status.SUCCESS)
			return Response.ok("Success").build();
		
		if(status == Status.FAIL)
			return Response.status(Response.Status.NOT_MODIFIED).entity("FAILED").build();
		
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("SQL ERROR").build();

	}

	/*
	 * updates advertisement name
	 * @param, authorization String
	 * @param, id
	 * @param, name
	 * @return, HttpResponse
	 */
	@Path("/updateAdvertisement/{id}/{name}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateAdvertisementName(@HeaderParam("Authorization") String authorizationString, @PathParam("id") int id,@PathParam("name") String name)
	{	
		if (!"get-2018".equals(authorizationString)) 
		{	
			return Response.status(401).build();
		}

		Status status = advertisementController.updateAdvertisement(id, name);
		
		if(status == Status.SUCCESS)
			return Response.ok("Success").build();
		if(status == Status.NOTEXISTS)
			return Response.status(Response.Status.NOT_FOUND).entity("Invalid data/Not exists in table").build();
		
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("SQL ERROR").build();
	}
	
	
	/*
	 * deletes advertisement
	 * @param, authorization String
	 * @param, id
	 * @return, HttpResponse
	 */
	@Path("/deleteAdvertisement/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAdvertisement(@HeaderParam("Authorization") String authorizationString, @PathParam("id") int id)
	{	
		if (!"get-2018".equals(authorizationString)) {
			
			return Response.status(401).build();
		}

		Status status = advertisementController.deleteAdvertisement(id);
		
		if(status == Status.SUCCESS)
			return Response.ok("Success").build();
		if(status == Status.NOTEXISTS)
			return Response.status(Response.Status.NOT_FOUND).entity("Invalid data/Not exists in table").build();
		
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("SQL ERROR").build();
	}
	
	
	
}
