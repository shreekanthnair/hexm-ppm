package com.acnovate.hexm.ppm.resources.converter;

import com.acnovate.hexm.common.web.resources.converter.AbstractResourceConverter;
import com.acnovate.hexm.common.web.resources.project.LocationResource;
import com.acnovate.hexm.ppm.model.Location;

/**
 * @author Shreekanth Nair
 *
 */
public class LocationToLocationResourceConverter implements AbstractResourceConverter<Location, LocationResource> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acnovate.hexm.common.web.resources.converter.
	 * AbstractResourceConverter#convert(java.lang.Object)
	 */
	@Override
	public LocationResource convert(Location source) {
		LocationResource locationResource = new LocationResource();
		locationResource.setCountry(source.getCountry());
		locationResource.setCurrency(source.getCurrency());
		locationResource.setLocationId(source.getLocationId());
		locationResource.setLocationName(source.getLocationName());
		locationResource.setPerDM(source.getPerDM());
		locationResource.setRegion(source.getRegion());
		return locationResource;
	}

}
