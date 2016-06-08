package com.mindtree.bug.tracker.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author M1035940
 *
 */
@Entity
@Table(name = "Genie")
public class Genie {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slno;

	/**
	 * 
	 */
	@OneToOne
	@JoinColumn(name = "user")
	private User user;

	/**
	 * 
	 */
	@Column(name = "Location")
	private String location;

	/**
	 * 
	 */
	@Column(name = "Severity")
	private String severity;

	/**
	 * 
	 */
	@Column(name = "Status")
	private boolean status;

	/**
	 * 
	 */
	@Column(name = "MobileNum")
	private String mobilenum;

	/**
	 * 
	 */
	@Column(name = "Raised_date")
	@Temporal(TemporalType.DATE)
	private Date raiseddate;

	/**
	 * 
	 */
	@OneToOne
	@JoinColumn(name = "assignedTo")
	private User assignedTo;

	/**
	 * 
	 */
	@Column(name = "GenieType")
	private String genieType;

	/**
	 * @return
	 */
	public String getGenieType() {
		return genieType;
	}

	/**
	 * @param genieType
	 */
	public void setGenieType(String genieType) {
		this.genieType = genieType;
	}

	/**
	 * @return
	 */
	public int getSlno() {
		return slno;
	}

	/**
	 * @param slno
	 */
	public void setSlno(int slno) {
		this.slno = slno;
	}

	/**
	 * @return
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return
	 */
	public User getAssignedTo() {
		return assignedTo;
	}

	/**
	 * @param assignedTo
	 */
	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	/**
	 * @return
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * @param severity
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/**
	 * @return
	 */
	public boolean getStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return
	 */
	public String getMobilenum() {
		return mobilenum;
	}

	/**
	 * @param mobilenum
	 */
	public void setMobilenum(String mobilenum) {
		this.mobilenum = mobilenum;
	}

	/**
	 * @return
	 */
	public Date getRaiseddate() {
		return raiseddate;
	}

	/**
	 * @param raiseddate
	 */
	public void setRaiseddate(Date raiseddate) {
		this.raiseddate = raiseddate;
	}

}
