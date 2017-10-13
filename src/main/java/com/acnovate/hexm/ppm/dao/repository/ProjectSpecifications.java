package com.acnovate.hexm.ppm.dao.repository;

import org.springframework.data.jpa.domain.Specification;

import com.acnovate.hexm.ppm.model.Project;

public class ProjectSpecifications {

	private ProjectSpecifications() {
		// Private Specification Class default Constructor
		// to disable initialization
		super();
	}

	public static Specification<Project> filterProjectsByProjectCode(String projectCode) {
		return (rootQuery, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(rootQuery.get("projectCode"),
				projectCode);
	}

	public static Specification<Project> filterProjectsByClientName(String clientName) {
		return (rootQuery, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(rootQuery.get("clientName"),
				clientName);
	}

}
