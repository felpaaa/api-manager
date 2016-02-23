package com.acc;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestWrapper implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String surname;

	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	private String phone;

	private String country;

	@JsonCreator
	public RequestWrapper(@JsonProperty("name") final String name, @JsonProperty("surname") final String surname,
			@JsonProperty("email") final String email, @JsonProperty("phone") final String phone,
			@JsonProperty("country") final String country) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.country = country;
	}

	public RequestWrapper() {

	}

}
