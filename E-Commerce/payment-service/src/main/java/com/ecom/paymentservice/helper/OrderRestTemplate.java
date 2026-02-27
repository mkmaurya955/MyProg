package com.ecom.paymentservice.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrderRestTemplate {
	@Autowired
	private RestTemplate restTemplate;
	
	public String updateOrderStatus(Long orderId, String status) {
		String url = "http://localhost:8082/orders/updateOrderStatus/"+orderId+"/orderStatus/"+status;
		String stringObject = restTemplate.getForObject(url, String.class);
		System.out.println(stringObject);
		return stringObject;
	}

}
