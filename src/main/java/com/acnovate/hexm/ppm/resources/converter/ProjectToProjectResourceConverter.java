package com.acnovate.hexm.ppm.resources.converter;

import com.acnovate.hexm.common.web.resources.converter.AbstractResourceConverter;
import com.acnovate.hexm.common.web.resources.project.ProjectResource;
import com.acnovate.hexm.ppm.model.Project;

/**
 * @author Shreekanth Nair
 *
 */
public class ProjectToProjectResourceConverter implements AbstractResourceConverter<Project, ProjectResource> {

	private boolean convertLocation;
	private static final LocationToLocationResourceConverter LOCATION_CONVERTER = new LocationToLocationResourceConverter();

	public ProjectToProjectResourceConverter() {
		this(false);
	}

	public ProjectToProjectResourceConverter(boolean convertLocation) {
		this.convertLocation = convertLocation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.acnovate.hexm.common.web.resources.converter.
	 * AbstractResourceConverter#convert(java.lang.Object)
	 */
	@Override
	public ProjectResource convert(Project sourceProject) {
		ProjectResource projectResource = new ProjectResource();
		projectResource.setProjectCode(sourceProject.getProjectCode());
		projectResource.setProjectName(sourceProject.getProjectName());
		projectResource.setProjectManager(sourceProject.getProjectManager());
		projectResource.setPoNumber(sourceProject.getPoNumber());
		projectResource.setExternal(sourceProject.isExternalProject());
		projectResource.setClientName(sourceProject.getClientName());
		if (convertLocation) {
			projectResource.setLocation(LOCATION_CONVERTER.convert(sourceProject.getBaseLocation()));
		}
		return projectResource;
	}
}
