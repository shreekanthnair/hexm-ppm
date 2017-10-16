/**
 * 
 */
package com.acnovate.hexm.ppm.dao.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.acnovate.hexm.ppm.model.Location;

/**
 * @author Shreekanth Nair
 *
 */
public interface LocationRepository
		extends PagingAndSortingRepository<Location, Long>, JpaSpecificationExecutor<Location> {

	@Override
	public Set<Location> findAll();

	/**
	 * Finds a Location based on Location Id
	 * 
	 * @param locationId
	 * @return
	 */
	public Location findByLocationId(Long locationId);
}
