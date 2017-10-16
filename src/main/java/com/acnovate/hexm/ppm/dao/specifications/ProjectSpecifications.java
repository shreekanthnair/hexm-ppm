package com.acnovate.hexm.ppm.dao.specifications;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import com.acnovate.hexm.common.util.HexmFormatUtility;
import com.acnovate.hexm.ppm.model.Location_;
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

	public static Specification<Project> filterProjectsByLocationNames(Collection<String> locationNames) {
		return (rootQuery, criteriaQuery, criteriaBuilder) -> rootQuery.join(Project_.baseLocation)
				.get(Location_.locationName).in(locationNames);
	}

	/**
	 * For a given set of filters, it will create specification query based on
	 * optional<br>
	 * criteria to be added to findAll() query from repository method.
	 * 
	 * @param projectCode
	 * @param clientName
	 * @param external
	 * @param poNumber
	 * @param locationNames
	 * @return
	 */
	public static Specification<Project> buildSpecificationForFilters(String projectCode, String clientName,
			boolean external, Long poNumber, Collection<String> locationNames) {
		List<Specification<Project>> projectSpecs = new ArrayList<>();
		if (HexmFormatUtility.hasContent(projectCode)) {
			projectSpecs.add(ProjectSpecifications.filterProjectsByProjectCode(projectCode));
		}

		if (HexmFormatUtility.hasContent(clientName)) {
			projectSpecs.add(ProjectSpecifications.filterProjectsByClientName(clientName));
		}

		if (external) {
			projectSpecs.add(ProjectSpecifications.filterProjectsByExternal(external));
		}

		if (poNumber != null) {
			projectSpecs.add(ProjectSpecifications.filterProjectsByPoNumber(poNumber));
		}

		if (HexmFormatUtility.hasContent(locationNames)) {
			projectSpecs.add(ProjectSpecifications.filterProjectsByLocationNames(locationNames));
		}
		// Add the specification list to where and and specifications query
		// to be added into findAll() method of JPA Repository
		int elementCounter = 0;
		Specifications<Project> specificationQuery = null;
		for (Specification<Project> spec : projectSpecs) {
			if (elementCounter == 0) {
				specificationQuery = Specifications.where(spec);
				elementCounter++;
				continue;
			}
			specificationQuery.and(spec);
			elementCounter++;
		}

		return specificationQuery;
	}

}
