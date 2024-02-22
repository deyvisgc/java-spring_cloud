package com.example.customers.payment;

import lombok.Data;

@Data
public class PaymantRequest {
	private double amount;

	public PaymantRequest(double amount) {
		this.amount = amount;
	}
}
