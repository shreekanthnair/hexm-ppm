package com.acnovate.hexm.ppm.dao.specifications;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import com.acnovate.hexm.common.util.HexmFormatUtility;
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

	public static Specification<Location> filterLocationsByRegion(String region) {
		return (rootQuery, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(rootQuery.get(Location_.region),
				region);
	}

	public static Specification<Location> filterLocationsByCountry(String country) {
		return (rootQuery, criteriaQuery, criteriaBuilder) -> criteriaBuilder
				.equal(rootQuery.get(Location_.country), country);
	}

	public static Specification<Location> buildSpecificationsForFilters(String locationName, String region,
			String country) {
		List<Specification<Location>> locationSpecs = new ArrayList<>();
		if (HexmFormatUtility.hasContent(locationName)) {
			locationSpecs.add(filterLocationsByName(locationName));
		}

		if (HexmFormatUtility.hasContent(region)) {
			locationSpecs.add(filterLocationsByRegion(region));
		}

		if (HexmFormatUtility.hasContent(country)) {
			locationSpecs.add(filterLocationsByCountry(country));
		}

		int elementCounter = 0;
		Specifications<Location> specificationQuery = null;
		for (Specification<Location> spec : locationSpecs) {
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
