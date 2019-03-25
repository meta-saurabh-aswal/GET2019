package com.metacube.restfulws.controller;

import java.util.ArrayList;

import com.metacube.restfulws.utility.Status;

import com.metacube.restfulws.facade.AdvertisementFacade;
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
public class AdvertisementController
{

	AdvertisementFacade advertisementFacade= new AdvertisementFacade();
	
	/*
	 * get all advertisement
	 * @return list of advertisements
	 */
	public ArrayList<Advertisement> getAllAdvertisement()
	{
		return advertisementFacade.getAllAdvertisement();
	}
	
	/*
	 *get advertisement by Category id 
	 * @param, id of category
	 * @return list of advertisements having same category id
	 */
	public ArrayList<Advertisement> getAdvertisementByCategoryID(int id)
	{
		return advertisementFacade.getAdvertisementByCategoryID(id);
	}
	
	/*
	 * create advertisement
	 * @param, advertisement 
	 * @return Status
	 */
	public Status createAdvertisement(Advertisement advertisement)
	{
		return advertisementFacade.createAdvertisement(advertisement);
	}
	
	
	/*
	 * update any advertisement by its id
	 * @param id
	 * @param name
	 * @return Status
	 */
	public Status updateAdvertisement(int id, String name)
	{
		return advertisementFacade.updateAdvertisement(id, name);
	}
	
	/*
	 * Delete advertisement by its id
	 * @param id
	 * @return Status
	 */
	public Status deleteAdvertisement(int id)
	{
		return advertisementFacade.deleteAdvertisement(id);
	}
}