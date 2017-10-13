package com.acnovate.hexm.ppm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acnovate.hexm.common.web.resources.project.LocationResource;
import com.acnovate.hexm.ppm.service.LocationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/locations")
@Api(value = "Location API")
@ExposesResourceFor(LocationResource.class)
public class LocationController {

	private final LocationService locationService;
	
	@Autowired
	public LocationController(final LocationService locationService) {
		this.locationService = locationService;
	}
	
	@ApiOperation(value = "Get all the locations in master data", response = PagedResources.class, notes = "Query all the locations"
			+ "based on region/country/location name based on the requirement")
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaTypes.HAL_JSON_VALUE)
	public ResponseEntity<Page<LocationResource>> getAllLocations(
			@RequestParam(value = "locationName", required = false) String locationName,
			@RequestParam(value = "region", required = false) String region,
			@RequestParam(value = "country", required = false) String country,
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
		Page<LocationResource> pagedLocationResource = locationService.getAllLocationResources(locationName, region,
				country, pageNumber, pageSize);
		return ResponseEntity.ok(pagedLocationResource);
	}

	@ApiOperation(value = "Create a new Location Reference data in the system", response = LocationResource.class)
	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
	public ResponseEntity<LocationResource> createLocation(@RequestBody LocationResource locationResource) {
		LocationResource newLocationResource = locationService.createNewLocation(locationResource);
		return ResponseEntity.ok(newLocationResource);
	}
}
