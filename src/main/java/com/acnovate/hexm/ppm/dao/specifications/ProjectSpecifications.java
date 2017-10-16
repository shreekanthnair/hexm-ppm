package com.acnovate.hexm.ppm.dao.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.acnovate.hexm.ppm.model.Project;
import com.acnovate.hexm.ppm.model.Project_;

public class ProjectSpecifications {

	private ProjectSpecifications() {
		// Private Specification Class default Constructor
		// to disable initialization
		super();
	}

	public static Specification<Project> filterProjectsByProjectCode(String projectCode) {
		return (rootQuery, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(rootQuery.get(Project_.projectCode),
				projectCode);
	}

	public static Specification<Project> filterProjectsByClientName(String clientName) {
		return (rootQuery, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(rootQuery.get(Project_.clientName),
				clientName);
	}

	public static Specification<Project> filterProjectsByExternal(boolean isExternal) {
		return (rootQuery, criteriaQuery, criteriaBuilder) -> criteriaBuilder
				.equal(rootQuery.get(Project_.externalProject), isExternal);
	}

	public static Specification<Project> filterProjectsByPoNumber(Long poNumber) {
		return (rootQuery, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(rootQuery.get(Project_.poNumber),
				poNumber);
	}

}
