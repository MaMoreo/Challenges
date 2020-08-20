/**
 * 
 */
package com.klarna;

/**
 * Usually when you buy something, you're asked whether your credit card number,
 * phone number or answer to your most secret question is still correct.
 * However, since someone could look over your shoulder, you don't want that
 * shown on your screen. Instead, we mask it.
 * 
 * Your task is to write a function maskify, which will:
 * 
 * Mask all digits (0-9) with #, unless they are first or last four characters.
 * Never mask credit cards with less than 6 characters. Never mask non-digit
 * characters.
 * 
 * 
 * @author miguel
 *
 */
public class CreditCard {

	public static String maskify(String creditCardNumber) {
		
		if (creditCardNumber.length() < 6)
			return creditCardNumber;

		StringBuilder masked = new StringBuilder();
		masked.append(creditCardNumber.charAt(0));
		String allMasked = creditCardNumber.replaceAll("\\d", "#");
		masked.append(allMasked.substring(1, allMasked.length()-4));
		masked.append(creditCardNumber.substring(creditCardNumber.length()-4));
		
		return masked.toString();
	}
}
