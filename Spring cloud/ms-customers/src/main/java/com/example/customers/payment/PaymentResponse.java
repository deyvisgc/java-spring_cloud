package com.example.customers.payment;

import com.example.customers.PaymentStatus;

public class PaymentResponse {

	PaymentStatus status;

	public PaymentResponse(PaymentStatus status) {
		this.status = status;
	}

	public PaymentStatus getStatus() {
		return status;
	}
}
