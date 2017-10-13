/**
 * 
 */
package com.acnovate.hexm.ppm.dao.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.acnovate.hexm.ppm.model.Project;

/**
 * @author Shreekanth Nair
 *
 */
public interface ProjectRepository
		extends PagingAndSortingRepository<Project, Long>, JpaSpecificationExecutor<Project> {

}
