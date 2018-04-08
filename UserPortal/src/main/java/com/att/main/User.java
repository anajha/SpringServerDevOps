package com.att.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer recordId;
	
	@Column(name="id")
	String id;
	
	@Column(name="firstname")
	String firstName;
	
	@Column(name="lastname")
	String lastName;
	
	@Column(name="email")
	String email;

	public User() {}
	
	public User(String id,String firstName,String lastName,String email)
	{
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
