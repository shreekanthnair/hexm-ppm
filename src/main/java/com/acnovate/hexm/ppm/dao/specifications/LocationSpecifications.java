package com.acnovate.hexm.ppm.dao.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.acnovate.hexm.ppm.model.Location;
import com.acnovate.hexm.ppm.model.Location_;

public class LocationSpecifications {

	private LocationSpecifications() {
		// Private Specification Class default Constructor
		// to disable initialization
		super();
	}

	public static Specification<Location> filterLocationsByName(String locationName) {
		return (rootQuery, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(
				rootQuery.get(Location_.locationName),
				locationName);
	}

	public static Specification<Location> filterProjectsByRegion(String region) {
		return (rootQuery, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(rootQuery.get(Location_.region),
				region);
	}

	public static Specification<Location> filterProjectsByCountry(String country) {
		return (rootQuery, criteriaQuery, criteriaBuilder) -> criteriaBuilder
				.equal(rootQuery.get(Location_.country), country);
	}

}
