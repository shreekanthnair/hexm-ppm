package com.acnovate.hexm.ppm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import com.acnovate.hexm.common.web.resources.project.ProjectResource;
import com.acnovate.hexm.ppm.dao.repository.LocationRepository;
import com.acnovate.hexm.ppm.dao.repository.ProjectRepository;
import com.acnovate.hexm.ppm.dao.repository.ProjectSpecifications;
import com.acnovate.hexm.ppm.model.Location;
import com.acnovate.hexm.ppm.model.Project;
import com.acnovate.hexm.ppm.resources.converter.ProjectToProjectResourceConverter;
import com.acnovate.hexm.ppm.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	private ProjectRepository projectRepository;
	private LocationRepository locationRepository;
	private static final ProjectToProjectResourceConverter PROJECT_RESOURCE_CONVERTER = new ProjectToProjectResourceConverter(
			true);

	@Autowired
	public ProjectServiceImpl(ProjectRepository projectRepository, LocationRepository locationRepository) {
		this.projectRepository = projectRepository;
		this.locationRepository = locationRepository;
	}

	@Override
	public Page<ProjectResource> getAllProjectResources(String projectCode, String clientName, boolean external,
			Long poNumber, int pageNumber, int pageSize) {
		Pageable pageable = new PageRequest(pageNumber, pageSize);
		Page<Project> pagedProject = projectRepository
				.findAll(Specifications.where(ProjectSpecifications.filterProjectsByProjectCode(projectCode)),
						pageable);
		List<ProjectResource> projectResources = PROJECT_RESOURCE_CONVERTER.convert(pagedProject.getContent());
		return new PageImpl<>(projectResources, pageable, pagedProject.getTotalElements());
	}

	@Override
	public ProjectResource createNewProject(ProjectResource projectResource) {
		Project project = new Project();
		project.setProjectName(projectResource.getProjectName());
		project.setProjectManager(projectResource.getProjectManager());
		project.setProjectCode(projectResource.getProjectCode());
		project.setClientName(projectResource.getClientName());
		project.setPoNumber(projectResource.getPoNumber());
		project.setExternalProject(projectResource.isExternal());

		Location location = locationRepository.findByLocationId(projectResource.getLocation().getLocationId());
		project.setBaseLocation(location);

		project = projectRepository.save(project);
		return PROJECT_RESOURCE_CONVERTER.convert(project);
	}

}
