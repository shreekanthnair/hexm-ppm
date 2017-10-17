package com.acnovate.hexm.ppm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.acnovate.hexm.common.web.resources.project.LocationResource;
import com.acnovate.hexm.ppm.dao.repository.LocationRepository;
import com.acnovate.hexm.ppm.dao.specifications.LocationSpecifications;
import com.acnovate.hexm.ppm.model.Location;
import com.acnovate.hexm.ppm.resources.converter.LocationToLocationResourceConverter;
import com.acnovate.hexm.ppm.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	private LocationRepository locationRepository;

	private static final LocationToLocationResourceConverter LOCATION_CONVERTER = new LocationToLocationResourceConverter();

	@Autowired
	public LocationServiceImpl(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	@Override
	public Page<LocationResource> getAllLocationResources(String locationName, String region, String country,
			int pageNumber, int pageSize) {
		Pageable pageable = new PageRequest(pageNumber, pageSize);
		Page<Location> pagedLocation = locationRepository.findAll(
				LocationSpecifications.buildSpecificationsForFilters(locationName, region, country),
				new PageRequest(pageNumber, pageSize));
		List<LocationResource> locationResources = LOCATION_CONVERTER.convert(pagedLocation.getContent());
		return new PageImpl<>(locationResources, pageable, pagedLocation.getTotalElements());
	}

	@Override
	public LocationResource createNewLocation(LocationResource locationResource) {
		Location location = new Location();
		location.setLocationName(locationResource.getLocationName());
		location.setRegion(locationResource.getRegion());
		location.setCountry(locationResource.getCountry());
		location.setCurrency(locationResource.getCurrency());
		location.setPerDM(locationResource.getPerDM());
		location = locationRepository.save(location);
		return LOCATION_CONVERTER.convert(location);
	}

	@Override
	public LocationResource getLocationDetails(String locationName) {
		Location location = locationRepository.findOne(LocationSpecifications.filterLocationsByName(locationName));
		return LOCATION_CONVERTER.convert(location);
	}

}
