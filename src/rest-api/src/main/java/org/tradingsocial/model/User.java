package org.tradingsocial.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "registered_users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "full_name")
	private String fullName;
	@Column(name = "email_address")
	private String emailAddress;
	@Column(name = "password")
	private String password;
	@Column(name = "last_login_time")
	private Timestamp lastLoginTime;
	@Column(name = "password_profile")
	private String passwordProfile;
	@Column(name = "password_expiry_date")
	private Timestamp passwordExpiryDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getPasswordProfile() {
		return passwordProfile;
	}

	public void setPasswordProfile(String passwordProfile) {
		this.passwordProfile = passwordProfile;
	}

	public Timestamp getPasswordExpiryDate() {
		return passwordExpiryDate;
	}

	public void setPasswordExpiryDate(Timestamp passwordExpiryDate) {
		this.passwordExpiryDate = passwordExpiryDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result	+ ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result	+ ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + id;
		result = prime * result	+ ((lastLoginTime == null) ? 0 : lastLoginTime.hashCode());
		result = prime * result	+ ((password == null) ? 0 : password.hashCode());
		result = prime * result	+ ((passwordExpiryDate == null) ? 0 : passwordExpiryDate.hashCode());
		result = prime * result	+ ((passwordProfile == null) ? 0 : passwordProfile.hashCode());
		result = prime * result	+ ((userName == null) ? 0 : userName.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (id != other.id)
			return false;
		if (lastLoginTime == null) {
			if (other.lastLoginTime != null)
				return false;
		} else if (!lastLoginTime.equals(other.lastLoginTime))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (passwordExpiryDate == null) {
			if (other.passwordExpiryDate != null)
				return false;
		} else if (!passwordExpiryDate.equals(other.passwordExpiryDate))
			return false;
		if (passwordProfile == null) {
			if (other.passwordProfile != null)
				return false;
		} else if (!passwordProfile.equals(other.passwordProfile))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		
		return true;
	}

}
