package com.acnovate.hexm.ppm.controller.assembler;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;

import com.acnovate.hexm.common.util.HexmFormatUtility;
import com.acnovate.hexm.common.web.resources.assembler.AbstractResourceAssembler;
import com.acnovate.hexm.common.web.resources.project.LocationResource;
import com.acnovate.hexm.ppm.controller.LocationController;

@Component
public class LocationResourceAssembler extends AbstractResourceAssembler<LocationResource, LocationResource> {

	public LocationResourceAssembler() {
		super(LocationController.class, LocationResource.class);
	}

	@Override
	public LocationResource toResource(LocationResource locationResource) {
		String locationName = locationResource.getLocationName();
		if (HexmFormatUtility.hasContent(locationName)) {
			locationResource.add(ControllerLinkBuilder
					.linkTo(ControllerLinkBuilder.methodOn(LocationController.class).getLocationDetails(locationName))
					.withSelfRel());
		}
		return locationResource;
	}

}
