package com.amplifon.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.amplifon.domain.Customer;
import com.amplifon.services.CustomerDataAllignService;
import com.amplifon.services.CustomerDataAllignServiceAllignCustomerMasterDataRequest;
import com.bizmatica.onair.services.OnAirServiceException;
import com.bizmatica.onair.services.payload.OnAirServiceImplementationMethodResponse;

public class MasterCustomerAllignService implements CustomerDataAllignService {

	@Autowired
	private RestTemplate restTemplate;

	private String url;

	@Override
	public OnAirServiceImplementationMethodResponse<String> allignCustomerMasterData(
			CustomerDataAllignServiceAllignCustomerMasterDataRequest methodRequest) throws OnAirServiceException {
		HttpEntity<Customer> entity = new HttpEntity<Customer>(methodRequest.getKey());
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		return methodRequest.responseBuilder(response.getBody()).build();
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
