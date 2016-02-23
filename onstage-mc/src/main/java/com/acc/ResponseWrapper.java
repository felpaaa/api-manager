package com.acc;

import java.io.Serializable;
import java.util.List;

import com.amplifon.domain.Customer;
import com.amplifon.domain.CustomerList;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseWrapper implements Serializable {

	private final static long serialVersionUID = 1L;

	private List<Customer> list;

	public List<Customer> getList() {
		return this.list;
	}

	/**
	 * Default constructor for internal use CustomerList .
	 */
	@JsonCreator
	public ResponseWrapper(@JsonProperty("customerList") final CustomerList list) {
		super();
	}
}
