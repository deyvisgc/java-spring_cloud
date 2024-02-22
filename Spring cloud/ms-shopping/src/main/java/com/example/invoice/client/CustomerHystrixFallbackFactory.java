package com.example.invoice.client;

import com.example.invoice.model.Customer;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

public class CustomerHystrixFallbackFactory implements CustomerClient{
	@Override
	public ResponseEntity<Customer> getCustomer(long id) {
		System.err.println("Fallback para getCustomer debido a un error");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	public ResponseEntity<Customer> getCustomerss(String id) {
		try {
			// Lógica para obtener el cliente (puede lanzar una excepción)
			System.err.println("entro aquiii");
			Customer customer = Customer.builder()
							.firstName("none")
							.lastName("none")
							.email("none")
							.photoUrl("none").build();
			return ResponseEntity.ok(customer);
		} catch (Exception ex) {
			// Manejar la excepción y devolver un estado HTTP diferente
			System.err.println(ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
}
