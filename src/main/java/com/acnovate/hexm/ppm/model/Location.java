package com.acnovate.hexm.ppm.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = Location.TABLE)
public class Location implements Serializable {

	private static final long serialVersionUID = 7624214662501760039L;
	protected static final String TABLE = "location_reference";
	protected static final String COL_ID = "loc_ref_id";
	protected static final String ID_SEQ = "Seq_location_id";
	protected static final String COL_LOCATION = "location";
	protected static final String COL_REGION = "region";
	protected static final String COL_COUNTRY = "country";
	protected static final String COL_PER_DM = "per_dm";
	protected static final String COL_CURRENCY = "currency";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = ID_SEQ)
	@SequenceGenerator(name = ID_SEQ, sequenceName = ID_SEQ)
	@Column(name = COL_ID, nullable = false, unique = true, updatable = false)
	private Long locationId;

	@Column(name = COL_LOCATION, nullable = false, unique = true, updatable = true)
	private String locationName;

	@Column(name = COL_REGION, nullable = true)
	private String region;

	@Column(name = COL_COUNTRY, nullable = true)
	private String country;

	@Column(name = COL_PER_DM)
	private BigDecimal perDM;

	@Column(name = COL_CURRENCY)
	private String currency;

	/**
	 * @return the locationId
	 */
	public Long getLocationId() {
		return locationId;
	}

	/**
	 * @param locationId
	 *            the locationId to set
	 */
	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	/**
	 * @return the locationName
	 */
	public String getLocationName() {
		return locationName;
	}

	/**
	 * @param locationName
	 *            the locationName to set
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param region
	 *            the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the perDM
	 */
	public BigDecimal getPerDM() {
		return perDM;
	}

	/**
	 * @param perDM
	 *            the perDM to set
	 */
	public void setPerDM(BigDecimal perDM) {
		this.perDM = perDM;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
