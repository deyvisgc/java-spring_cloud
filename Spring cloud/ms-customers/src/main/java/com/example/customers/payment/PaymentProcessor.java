package com.example.customers.payment;

import com.example.customers.PaymentStatus;
import lombok.Data;

@Data
public class PaymentProcessor {
	private PaymentGateway paymentGateway;

	public PaymentProcessor(PaymentGateway paymentGateway) {
		this.paymentGateway = paymentGateway;
	}

	public boolean makePayment(double amount) {

		PaymentResponse response = paymentGateway.requestPayment(new PaymantRequest(amount));
		if (response.getStatus() == PaymentStatus.OK) {
			return true;
		} else {
			return false;
		}
	}
}
