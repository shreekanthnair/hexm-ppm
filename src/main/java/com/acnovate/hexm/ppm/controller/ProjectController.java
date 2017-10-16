package com.acnovate.hexm.ppm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acnovate.hexm.common.web.resources.project.ProjectResource;
import com.acnovate.hexm.ppm.service.ProjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/projects")
@Api(value = "Project API")
@ExposesResourceFor(ProjectResource.class)
public class ProjectController {

	private final ProjectService projectService;
	
	@Autowired
	public ProjectController(final ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@ApiOperation(value = "Gets all the projects assigned to the user", response = PagedResources.class, notes = "For the user "
			+ "requesting for all the projects, the API responds back with all the projects which are assigned.")
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaTypes.HAL_JSON_VALUE)
	public ResponseEntity<Page<ProjectResource>> getAllProjects(
			@RequestParam(value = "projectCode", required = false) String projectCode,
			@RequestParam(value = "clientName", required = false) String clientName,
			@RequestParam(value = "external", required = false) boolean external,
			@RequestParam(value = "poNumber", required = false) Long poNumber,
			@RequestParam(value = "locationNames", required = false) List<String> locationNames,
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "50") int pageSize) {
		Page<ProjectResource> pageProjectResource = projectService.getAllProjectResources(projectCode, clientName,
				external, poNumber, locationNames, pageNumber, pageSize);
		return ResponseEntity.ok(pageProjectResource);
	}

	@ApiOperation(value = "Create a new Project", response = ProjectResource.class, notes = "A new project is created"
			+ "using this API with the project code assigned by the user and responded back with Project ID")
	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaTypes.HAL_JSON_VALUE)
	public ResponseEntity<ProjectResource> createProject(@RequestBody ProjectResource projectResource) {
		ProjectResource newProjectResource = projectService.createNewProject(projectResource);
		return ResponseEntity.ok(newProjectResource);
	}

	@ApiOperation(value = "Gets a Project Details", response = ProjectResource.class, notes = "Get the project details based"
			+ " on project code")
	@RequestMapping(value = "/{projectCode}", method = RequestMethod.GET, produces = MediaTypes.HAL_JSON_VALUE)
	public ResponseEntity<ProjectResource> getProjectDetails(@PathVariable(value = "projectCode") String projectCode) {
		ProjectResource newProjectResource = projectService.getProjectDetails(projectCode);
		return ResponseEntity.ok(newProjectResource);
	}
}
