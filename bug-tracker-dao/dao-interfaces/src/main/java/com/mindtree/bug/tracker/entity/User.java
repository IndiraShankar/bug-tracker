package com.mindtree.bug.tracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author M1035940
 *
 */
@Entity
@Table(name = "User")
public class User {

	/**
	 * 
	 */
	@Id
	@Column(name = "username")
	private String username;

	/**
	 * 
	 */
	@Column(name = "password")
	private String password;

	/**
	 * 
	 */
	@Column(name = "enabled")
	private boolean enabled;

	/**
	 * @return
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
