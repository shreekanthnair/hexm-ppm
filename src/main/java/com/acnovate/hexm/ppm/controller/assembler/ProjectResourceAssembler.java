package com.acnovate.hexm.ppm.controller.assembler;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;

import com.acnovate.hexm.common.util.HexmFormatUtility;
import com.acnovate.hexm.common.web.resources.assembler.AbstractResourceAssembler;
import com.acnovate.hexm.common.web.resources.project.LocationResource;
import com.acnovate.hexm.common.web.resources.project.ProjectResource;
import com.acnovate.hexm.ppm.controller.LocationController;
import com.acnovate.hexm.ppm.controller.ProjectController;

@Component
public class ProjectResourceAssembler extends AbstractResourceAssembler<ProjectResource, ProjectResource> {

	public ProjectResourceAssembler() {
		super(ProjectController.class, ProjectResource.class);
	}

	@Override
	public ProjectResource toResource(ProjectResource projectResource) {
		String projectCode = projectResource.getProjectCode();
		if (HexmFormatUtility.hasContent(projectCode)) {
			projectResource.add(ControllerLinkBuilder
					.linkTo(ControllerLinkBuilder.methodOn(ProjectController.class).getProjectDetails(projectCode))
					.withSelfRel());
		}

		LocationResource locationResource = projectResource.getLocation();
		if (locationResource != null) {
			locationResource.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(LocationController.class)
					.getLocationDetails(locationResource.getLocationName())).withSelfRel());
			projectResource.setLocation(locationResource);
		}
		return projectResource;
	}

}
