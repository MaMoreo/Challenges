package com.klarna;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberToOrdinalTests {

	@Test
	public void shouldHandleSingleDigitsSpecialCases() {
		assertEquals("0", Challenge.numberToOrdinal(0));
		assertEquals("1st", Challenge.numberToOrdinal(1));
		assertEquals("2nd", Challenge.numberToOrdinal(2));
		assertEquals("3rd", Challenge.numberToOrdinal(3));
	}

	@Test
	public void shouldHandleSingleDigitsNormalCases() {
		assertEquals("4th", Challenge.numberToOrdinal(4));
		assertEquals("5th", Challenge.numberToOrdinal(5));
		assertEquals("6th", Challenge.numberToOrdinal(6));
		assertEquals("7th", Challenge.numberToOrdinal(7));
		assertEquals("8th", Challenge.numberToOrdinal(8));
		assertEquals("9th", Challenge.numberToOrdinal(9));
	}

	@Test
	public void shouldHandleDoubleDigitsTeenCasesExceptions() {
		assertEquals("11th", Challenge.numberToOrdinal(11));
		assertEquals("12th", Challenge.numberToOrdinal(12));
		assertEquals("13th", Challenge.numberToOrdinal(13));
	}

	@Test
	public void shouldHandleDobuleDigitsTeenCases() {
		assertEquals("14th", Challenge.numberToOrdinal(14));
		assertEquals("15th", Challenge.numberToOrdinal(15));
		assertEquals("16th", Challenge.numberToOrdinal(16));
		assertEquals("17th", Challenge.numberToOrdinal(17));
		assertEquals("18th", Challenge.numberToOrdinal(18));
		assertEquals("19th", Challenge.numberToOrdinal(19));
	}

	@Test
	public void shouldHandleDoubleDigitsNormalCasesRest() {
		assertEquals("20th", Challenge.numberToOrdinal(20));
		assertEquals("21st", Challenge.numberToOrdinal(21));
		assertEquals("22nd", Challenge.numberToOrdinal(22));
		assertEquals("23rd", Challenge.numberToOrdinal(23));
		assertEquals("24th", Challenge.numberToOrdinal(24));
	}
	
	@Test
	public void shouldHandleSDifferentCasesRest() {
		assertEquals("120th", Challenge.numberToOrdinal(120));
		assertEquals("121st", Challenge.numberToOrdinal(121));
		assertEquals("122nd", Challenge.numberToOrdinal(122));
		assertEquals("123rd", Challenge.numberToOrdinal(123));
		assertEquals("1024th", Challenge.numberToOrdinal(1024));
	}

}
