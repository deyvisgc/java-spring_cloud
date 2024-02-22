package com.example.customers.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

	@Test
	public void testRepetMultiple() {
		assertEquals("holaholahola", StringUtil.repear("hola", 3));
	}
	@Test
	public void testRepetOne() {
		assertEquals("hola", StringUtil.repear("hola", 1));
	}
	@Test
	public void testRepetZeroTimes() {
		assertEquals("", StringUtil.repear("hola", 0));
	}
	@Test
	public void testRepetnegativeTimes() {
		assertThrows(IllegalArgumentException.class, () ->  StringUtil.repear("hola", -1));
	}
}