package com.example.customers.utils;

import com.example.customers.PaymentStatus;
import com.example.customers.payment.PaymentProcessor;
import com.example.customers.payment.PaymentResponse;
import com.example.customers.payment.PaymentGateway;
import  com.example.customers.payment.PaymentResponse.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PaymentProcessorTest {
	private PaymentGateway paymentGateway;
	private PaymentProcessor paymentProcessor;

	//Esto se ejecuta antes de cada metodo
	@BeforeEach
	public void setup() {
		 paymentGateway = Mockito.mock(PaymentGateway.class);
		 paymentProcessor = new PaymentProcessor(paymentGateway);
	}

	@Test
	public void  payment_is_correct() {

		// simulo con mockito porque mi payment gateway es un interface
		Mockito.when(paymentGateway.requestPayment(Mockito.any()))
						.thenReturn(new PaymentResponse(PaymentStatus.OK));
		PaymentProcessor paymentProcessor = new PaymentProcessor(paymentGateway);

		assertTrue(paymentProcessor.makePayment(1000));
	}
	@Test
	public void payment_is_wrong() {
		Mockito.when(paymentGateway.requestPayment(Mockito.any()))
						.thenReturn(new PaymentResponse(PaymentStatus.ERROR));
		assertFalse(paymentProcessor.makePayment(1000));
	}
}