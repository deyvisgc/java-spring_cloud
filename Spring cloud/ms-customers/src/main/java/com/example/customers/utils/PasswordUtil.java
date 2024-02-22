package com.example.customers.utils;

import org.apache.http.impl.cookie.BrowserCompatSpecFactory;

public class PasswordUtil {
	public enum SecurityLevel {
		WEAK, MEDIUM, STRONG
	}
	public static SecurityLevel assetPassword(String password) {

		if (password.length() < 8) {
			return SecurityLevel.WEAK;
		}
		if (password.matches("[a-zA-Z]+")) {
			return  SecurityLevel.WEAK;
		}
		if (password.matches("[a-zA-Z0-9]+")) {
			return  SecurityLevel.MEDIUM;
		}
		return SecurityLevel.STRONG;
	}
}
