package com.example.albinerotask.service;

import java.util.Arrays;

import com.example.albinerotask.dto.OrderDTO;
import com.example.albinerotask.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
	@Autowired
	RestTemplate restTemplate;

	public OrderDTO create(OrderRequest orderRequest) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		  headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		  HttpEntity <OrderRequest> entity = new HttpEntity<OrderRequest>(orderRequest, headers);
		  OrderDTO response = restTemplate.postForObject("http://localhost:8090/api/payment",  entity, OrderDTO.class);
		  return response;
	}

	public OrderDTO get(Long id) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		OrderDTO response = restTemplate.exchange("http://localhost:8090/api/payment/"+id,HttpMethod.GET, entity, OrderDTO.class).getBody();
		return response;
	}

}
