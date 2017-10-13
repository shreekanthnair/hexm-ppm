package com.acnovate.hexm.ppm.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = Project.TABLE)
public class Project implements Serializable {

	private static final long serialVersionUID = 7624214662501760039L;
	protected static final String TABLE = "project";
	protected static final String COL_ID = "project_id";
	protected static final String ID_SEQ = "Seq_" + COL_ID;
	protected static final String COL_PROJECT_CODE = "project_code";
	protected static final String COL_PROJECT_NAME = "project_name";
	protected static final String COL_EXTERNAL_PROJECT = "external_project";
	protected static final String COL_CLIENT_NAME = "client_name";
	protected static final String COL_PO_NUMBER = "po_number";
	protected static final String COL_BASE_LOCATION = "base_location";
	protected static final String COL_PROJECT_MANAGER = "project_manager";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = ID_SEQ)
	@SequenceGenerator(name = ID_SEQ, sequenceName = ID_SEQ)
	@Column(name = COL_ID, nullable = false, unique = true, updatable = false)
	private Long projectId;

	@Column(name = COL_PROJECT_CODE, nullable = false, unique = true, updatable = true)
	private String projectCode;

	@Column(name = COL_PROJECT_NAME, nullable = false)
	private String projectName;

	@Column(name = COL_PO_NUMBER, nullable = true)
	private Long poNumber;

	@Column(name = COL_CLIENT_NAME)
	private String clientName;

	@Column(name = COL_PROJECT_MANAGER)
	private String projectManager;

	@Column(name = COL_EXTERNAL_PROJECT)
	private boolean externalProject;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = COL_BASE_LOCATION)
	private Location baseLocation;

	/**
	 * @return the projectId
	 */
	public Long getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId
	 *            the projectId to set
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the projectCode
	 */
	public String getProjectCode() {
		return projectCode;
	}

	/**
	 * @param projectCode
	 *            the projectCode to set
	 */
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName
	 *            the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * @return the poNumber
	 */
	public Long getPoNumber() {
		return poNumber;
	}

	/**
	 * @param poNumber
	 *            the poNumber to set
	 */
	public void setPoNumber(Long poNumber) {
		this.poNumber = poNumber;
	}

	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}

	/**
	 * @param clientName
	 *            the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * @return the projectManager
	 */
	public String getProjectManager() {
		return projectManager;
	}

	/**
	 * @param projectManager
	 *            the projectManager to set
	 */
	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	/**
	 * @return the externalProject
	 */
	public boolean isExternalProject() {
		return externalProject;
	}

	/**
	 * @param externalProject
	 *            the externalProject to set
	 */
	public void setExternalProject(boolean externalProject) {
		this.externalProject = externalProject;
	}

	/**
	 * @return the baseLocation
	 */
	public Location getBaseLocation() {
		return baseLocation;
	}

	/**
	 * @param baseLocation
	 *            the baseLocation to set
	 */
	public void setBaseLocation(Location baseLocation) {
		this.baseLocation = baseLocation;
	}
}
