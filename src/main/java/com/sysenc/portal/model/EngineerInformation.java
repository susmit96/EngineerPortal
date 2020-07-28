package com.sysenc.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="engineer_information")
@NamedQuery(name="EngineerInformation.findAll", query = "SELECT a FROM EngineerInformation a")
public class EngineerInformation implements Serializable{

	 private static final long serialVersionUID = 1L;

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid")
	 @GenericGenerator(name = "uuid", strategy = "uuid")
	 @Column(name="engineer_id")
	 private String engineerId;

	 @Column(name="full_name")
	 private String fullName;

	 @Column(name="gender")
	 private String gender;

	 @Column(name="address")
	 private String address;

	 @Column(name="mail_address")
	 private String mailAddress;

	 @Column(name="phone_number")
	 private String phoneNumber;

	 @Column(name="skill")
	 private String skill;

	 @Column(name="comment")
	 private String comment;

	 @Column(name="register_date")
	 private String registerDate;
}