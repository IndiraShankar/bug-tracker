package com.mindtree.bug.tracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author M1035940
 *
 */
@Entity
@Table(name = "UserRole")
public class UserRole {
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private int userRollId;

	/**
	 * 
	 */
	@OneToOne
	@JoinColumn(name = "username")
	private User user;

	/**
	 * 
	 */
	@Column(name = "role")
	private String role;

	/**
	 * @return
	 */
	public int getUserRollId() {
		return userRollId;
	}

	/**
	 * @param userRollId
	 */
	public void setUserRollId(int userRollId) {
		this.userRollId = userRollId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRoles [userRollId=" + userRollId + ", user=" + user + ", role=" + role + "]";
	}

}
