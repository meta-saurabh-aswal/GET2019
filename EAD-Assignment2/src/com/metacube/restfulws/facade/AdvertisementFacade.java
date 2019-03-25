package com.metacube.restfulws.facade;

import java.util.ArrayList;

import com.metacube.restfulws.utility.Status;

import com.metacube.restfulws.dao.AdvertisementDao;
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
public class AdvertisementFacade {

	AdvertisementDao advertisementDao= new AdvertisementDao();
	
	/*
	 * get all advertisement
	 * @return list of advertisements
	 */
	public ArrayList<Advertisement> getAllAdvertisement()
	{
		return advertisementDao.getAllAdvertisement();
	}
	
	/*
	 *get advertisement by Category id 
	 * @param, id of category
	 * @return list of advertisements having same category id
	 */
	public ArrayList<Advertisement> getAdvertisementByCategoryID(int id)
	{
		return advertisementDao.getAdvertisementByCategoryID(id);
	}
	 
	/*
	 * create advertisement
	 * @param, advertisement 
	 * @return Status
	 */
	public Status createAdvertisement(Advertisement advertisement)
	{
		return advertisementDao.createAdvertisement(advertisement);
	}
	
	/*
	 * update any advertisement by its id
	 * @param id
	 * @param name
	 * @return Status
	 */
	public Status updateAdvertisement(int id, String name)
	{
		return advertisementDao.updateAdvertisement(id ,name);
	}
	
	/*
	 * Delete advertisement by its id
	 * @param id
	 * @return Status
	 */
	public Status deleteAdvertisement(int id)
	{
		return advertisementDao.deleteAdvertisement(id);
	}
}