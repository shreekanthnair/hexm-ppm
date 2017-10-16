package com.acnovate.hexm.ppm.model;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Location.class)
public abstract class Location_ {

	public static volatile SingularAttribute<Location, String> country;
	public static volatile SingularAttribute<Location, String> locationName;
	public static volatile SingularAttribute<Location, Long> locationId;
	public static volatile SingularAttribute<Location, String> currency;
	public static volatile SingularAttribute<Location, String> region;
	public static volatile SingularAttribute<Location, BigDecimal> perDM;

}

