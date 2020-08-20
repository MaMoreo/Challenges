package com.klarna;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class SampleTest {

	@Test
	public void shouldMaskDigitsForBasicCreditCards() {
		assertEquals("5###########0694", CreditCard.maskify("5512103073210694"));
	}

	@Test
	public void shouldNotMaskDigitsForShortCreditCards() {
		assertEquals("54321", CreditCard.maskify("54321"));
	}
	
	@Test
	public void shouldMaskDigitsForComplexCreditCards() {
		assertEquals("5-###-###-###-#69-4", CreditCard.maskify("5-121-300-321-069-4"));
	}
	
	@Test
	public void shouldNotMaskLettersForComplexCreditCards() {
		assertEquals("A-BBB-CCC-YY-WWW-Z", CreditCard.maskify("A-BBB-CCC-YY-WWW-Z"));
	}
	
	@Test
	public void shouldNotMaskLettersMaskDigitsForComplexCreditCards() {
		assertEquals("A#-##B-C#C-YY-WW#-Z14", CreditCard.maskify("A1-22B-C7C-YY-WW6-Z14"));
	}
}
