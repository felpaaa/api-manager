package com.acc;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerWrapper implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id_customer_lr;

	public String getId_customer_lr() {
		return this.id_customer_lr;
	}

	private String id_customer_fox;

	public String getId_customer_fox() {
		return this.id_customer_fox;
	}

	private String name;

	public String getName() {
		return this.name;
	}

	private String surname;

	public String getSurname() {
		return this.surname;
	}

	private String email;

	public String getEmail() {
		return this.email;
	}

	private String phone;

	public String getPhone() {
		return this.phone;
	}

	private Boolean privacy;

	public Boolean getPrivacy() {
		return this.privacy;
	}

	private Boolean consensus;

	public Boolean getConsensus() {
		return this.consensus;
	}

	private String address1;

	public String getAddress1() {
		return this.address1;
	}

	private String address2;

	public String getAddress2() {
		return this.address2;
	}

	private String city;

	public String getCity() {
		return this.city;
	}

	private String zip;

	public String getZip() {
		return this.zip;
	}

	private String locale;

	public String getLocale() {
		return this.locale;
	}

	private Date update_date;

	public Date getUpdate_date() {
		return this.update_date;
	}

	public CustomerWrapper(@JsonProperty("id_customer_lr") final String id_customer_lr,
			@JsonProperty("id_customer_fox") final String id_customer_fox, @JsonProperty("name") final String name,
			@JsonProperty("surname") final String surname, @JsonProperty("email") final String email,
			@JsonProperty("phone") final String phone, @JsonProperty("privacy") final Boolean privacy,
			@JsonProperty("consensus") final Boolean consensus, @JsonProperty("address1") final String address1,
			@JsonProperty("address2") final String address2, @JsonProperty("city") final String city,
			@JsonProperty("zip") final String zip, @JsonProperty("locale") final String locale,
			@JsonProperty("update_date") final Date update_date) {
		super();
		this.id_customer_lr = id_customer_lr;
		this.id_customer_fox = id_customer_fox;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.privacy = privacy;
		this.consensus = consensus;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.zip = zip;
		this.locale = locale;
		this.update_date = update_date;

	}

}
