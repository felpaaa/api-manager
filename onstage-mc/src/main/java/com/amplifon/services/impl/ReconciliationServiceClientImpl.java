package com.amplifon.services.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.amplifon.domain.Customer;
import com.amplifon.domain.ReconciliationRequest;
import com.amplifon.services.ReconciliationService;
import com.amplifon.services.ReconciliationServiceFindCustomerForReconciliationRequest;
import com.bizmatica.onair.services.OnAirServiceException;
import com.bizmatica.onair.services.payload.OnAirServiceImplementationMethodResponse;

public class ReconciliationServiceClientImpl implements ReconciliationService {

	@Autowired
	private RestTemplate restTemplate;

	private String url;

	@Override
	public OnAirServiceImplementationMethodResponse<List<Customer>> findCustomerForReconciliation(
			ReconciliationServiceFindCustomerForReconciliationRequest methodRequest) throws OnAirServiceException {
		HttpEntity<ReconciliationRequest> entity = new HttpEntity<ReconciliationRequest>(methodRequest.getKey());
		ResponseEntity<Customer[]> response = restTemplate.exchange(url, HttpMethod.POST, entity, Customer[].class);
		List<Customer> asList = Arrays.asList(response.getBody());
		return methodRequest.responseBuilder(asList).build();

	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
