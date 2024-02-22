package com.example.customers.utils;

public class StringUtil {

	public static String repear(String str, int times) {
		String result = "";
		if (times < 0) {
			throw new IllegalArgumentException("number not negative");
		}
		for (int i = 0; i < times; i++) {
			result += str;
		}
		return result;
	}
}
