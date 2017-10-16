package com.acnovate.hexm.ppm.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Project.class)
public abstract class Project_ {

	public static volatile SingularAttribute<Project, String> projectManager;
	public static volatile SingularAttribute<Project, String> projectCode;
	public static volatile SingularAttribute<Project, String> clientName;
	public static volatile SingularAttribute<Project, Boolean> externalProject;
	public static volatile SingularAttribute<Project, Location> baseLocation;
	public static volatile SingularAttribute<Project, String> projectName;
	public static volatile SingularAttribute<Project, Long> projectId;
	public static volatile SingularAttribute<Project, Long> poNumber;

}

