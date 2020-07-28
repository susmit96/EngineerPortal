package com.sysenc.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="admin_login")
public class AdminLogin{

	@Id
	@Column(name="Username")
	private String userName;

	@Column(name="Password")
	private String password;
}
