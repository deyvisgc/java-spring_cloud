package com.example.customers.payment;

public interface PaymentGateway {
	PaymentResponse requestPayment(PaymantRequest paymantRequest);
}
