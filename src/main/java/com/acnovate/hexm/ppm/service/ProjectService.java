package com.acnovate.hexm.ppm.service;

import org.springframework.data.domain.Page;

import com.acnovate.hexm.common.web.resources.project.ProjectResource;

public interface ProjectService {

	/**
	 * Gets all the Projects assigned to a user
	 * @param pageSize 
	 * @param pageNumber 
	 * @param poNumber 
	 * @param external 
	 * @param clientName 
	 * @param projectCode 
	 * @return
	 */
	public Page<ProjectResource> getAllProjectResources(String projectCode, String clientName, boolean external,
			Long poNumber, int pageNumber, int pageSize);

	/**
	 * Service to create a new Project Resource in the system.
	 * 
	 * @param projectResource
	 * @return {@link ProjectResource}
	 */
	public ProjectResource createNewProject(ProjectResource projectResource);
}
