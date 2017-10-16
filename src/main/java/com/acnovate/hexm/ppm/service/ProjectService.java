package com.acnovate.hexm.ppm.service;

import java.util.Collection;

import org.springframework.data.domain.Page;

import com.acnovate.hexm.common.web.resources.project.ProjectResource;

public interface ProjectService {

	/**
	 * Gets all the Projects assigned to a user
	 * 
	 * @param projectCode
	 * @param clientName
	 * @param external
	 * @param poNumber
	 * @param locationNames
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	public Page<ProjectResource> getAllProjectResources(String projectCode, String clientName, boolean external,
			Long poNumber, Collection<String> locationNames, int pageNumber, int pageSize);

	/**
	 * Service to create a new Project Resource in the system.
	 * 
	 * @param projectResource
	 * @return {@link ProjectResource}
	 */
	public ProjectResource createNewProject(ProjectResource projectResource);

	/**
	 * Gets Project Details based on Project Code
	 * 
	 * @param projectCode
	 * @return
	 */
	public ProjectResource getProjectDetails(String projectCode);
}
