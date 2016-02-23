package com.acc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.amplifon.domain.Customer;
import com.amplifon.domain.ReconciliationRequest;

public class TestRest {

	private static String url = "http://52.29.58.25/restStub/esb/reconciliation";

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		ReconciliationRequest request = new ReconciliationRequest("tet", "adfas", "sdad", "sdasd", "sdad");

		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		List<MediaType> accepts = new ArrayList<>();
		accepts.add(MediaType.APPLICATION_JSON);
		requestHeaders.setAccept(accepts);
		HttpEntity<ReconciliationRequest> entity = new HttpEntity<ReconciliationRequest>(request);

		// ResponseEntity<CustomerList> response = restTemplate.exchange(url,
		// HttpMethod.POST, entity, CustomerList.class);

		ResponseEntity<Customer[]> response = restTemplate.exchange(url, HttpMethod.POST, entity, Customer[].class);
		List<Customer> asList = Arrays.asList(response.getBody());
		System.out.println(response);
	}

}
