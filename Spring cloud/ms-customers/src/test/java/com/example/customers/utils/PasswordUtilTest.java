package com.example.customers.utils;

import org.junit.jupiter.api.Test;

import static com.example.customers.utils.PasswordUtil.SecurityLevel.WEAK;
import static com.example.customers.utils.PasswordUtil.SecurityLevel.MEDIUM;
import static com.example.customers.utils.PasswordUtil.SecurityLevel.STRONG;
import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilTest {
	@Test
	public void  weak_when_has_less_than_8_letters() {
		assertEquals(WEAK, PasswordUtil.assetPassword("sdsdsasas"));
	}
	@Test
	public void  weak_when_has_only_than_letters() {
		assertEquals(WEAK, PasswordUtil.assetPassword("acdsdsasasa"));
	}
	@Test
	public void  medium_when_has_letters_and_numbers() {
		assertEquals(MEDIUM, PasswordUtil.assetPassword("abcdf1212"));
	}
	@Test
	public void strong_when_has_letters_and_numbers_and_simbols() {
		assertEquals(STRONG, PasswordUtil.assetPassword("abcdf1212#"));
	}

}