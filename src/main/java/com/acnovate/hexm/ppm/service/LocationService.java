package com.acnovate.hexm.ppm.service;

import org.springframework.data.domain.Page;

import com.acnovate.hexm.common.web.resources.project.LocationResource;

public interface LocationService {


	/**
	 * Get all the Locations based on the Filter Criteria provided in the <br>
	 * request parameters
	 * 
	 * @param locationName
	 *            Location Name
	 * @param region
	 *            Region of the location for example ASIA, EUROPE, AFRICA, NAM,
	 *            SAM, AUS etc.
	 * @param country
	 *            Country name like India, Germany, USA,
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public Page<LocationResource> getAllLocationResources(String locationName, String region, String country,
			int pageNumber, int pageSize);

	/**
	 * Service to create a new Location Reference Data in the system.
	 * 
	 * @param locationResource
	 *            Location Resource object is created from input
	 *            {@link LocationResource}
	 * @return {@link LocationResource}
	 */
	public LocationResource createNewLocation(LocationResource locationResource);

	/**
	 * Get the location details based on location name in the system.
	 * 
	 * @param locationName
	 * @return
	 */
	public LocationResource getLocationDetails(String locationName);
}
