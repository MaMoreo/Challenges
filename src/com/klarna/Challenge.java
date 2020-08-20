package com.klarna;

/*
 * Task

Finish the function numberToOrdinal, which should take a number and return it as a string with the correct ordinal indicator suffix (in English). For example, 1 turns into "1st".

For the purposes of this challenge, you may assume that the function will always be passed a non-negative integer. If the function is given 0 as an argument, it should return '0' (as a string).

To help you get started, here is an excerpt from Wikipedia's page on Ordinal Indicators:

    st is used with numbers ending in 1 (e.g. 1st, pronounced first)
    nd is used with numbers ending in 2 (e.g. 92nd, pronounced ninety-second)
    rd is used with numbers ending in 3 (e.g. 33rd, pronounced thirty-third)
    As an exception to the above rules, all the "teen" numbers ending with 11, 12 or 13 use -th (e.g. 11th, pronounced eleventh, 112th, pronounced one hundred [and] twelfth)
    th is used for all other numbers (e.g. 9th, pronounced ninth).

 */
public class Challenge {

	public static String numberToOrdinal(Integer number) {

		if (number == 0) {
			return "0";
		}

		int units = number % 10;

		if (number > 10 && units == 1 || units == 2 || units == 3) {
			int decens = (number / 10) % 10;

			if (decens == 1) {
				return number + "th";
			}

		}

		if (units == 1) {
			return number + "st";
		}
		if (units == 2) {
			return number + "nd";
		}

		if (units == 3) {
			return number + "rd";
		}

		return number + "th";
	}
}
