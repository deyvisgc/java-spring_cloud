package com.example.invoice.client;

import com.example.invoice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "customer-service")
@RequestMapping("/customers")
public interface CustomerClient {
	@GetMapping(value = "/customers/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id);
}
