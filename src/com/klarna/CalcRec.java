package com.klarna;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcRec {

	public double evaluate(String expr) {

		String[] digits = expr.split(" ");

		int index = digits.length - 1;
		if (isOperator(digits[index]) && isNumber(digits[index - 1]) && isNumber(digits[index - 2])) {

			String op = digits[index];
			String n1 = digits[index - 2];
			String n2 = digits[index - 1]; // the last one
			
			String result = performOperation(n1, n2, op);
			return Double.valueOf(result);
		}

		// n1 is missing
		if (isOperator(digits[index]) && isOperator(digits[index - 1])) {

			String digits_exp = "";
			for (int i = 1, j = 0; i < digits.length - 1; i++, j++) {
				digits_exp += digits[i] + " ";
			}

			digits_exp = digits_exp.trim();

			String op = digits[index];
			String n1 = digits[0]; // the last one
			Double n2 = evaluate(digits_exp);
			

			// recursive call
			return Double.valueOf(performOperation(n1, n2.toString(), op));
		}

		// n1 is missing
		if (isOperator(digits[index]) && isNumber(digits[index - 1])
			&& isOperator(digits[index - 2])) {

			String digits_exp = "";
			for (int i = 0; i < digits.length - 2; i++) {
				digits_exp += digits[i] + " ";
			}

			digits_exp = digits_exp.trim();

			String op = digits[index];
			Double n1 =  evaluate(digits_exp); 
			String n2 = digits[index-1];

			// recursive call
			return Double.valueOf(performOperation(n1.toString(), n2, op));
		}

		return 0;
	}

	private boolean isNumber(String a) {
		Pattern p = Pattern.compile("\\d[\\.\\d]*"); // numbers with decimals
		Matcher m = p.matcher(a.toString());
		return m.matches();
	}

	private boolean isOperator(String a) {
		Pattern p = Pattern.compile("[-|\\+|*|/]");
		Matcher m = p.matcher(a.toString());
		return m.matches();
	}

	private String performOperation(String n1, String n2, String op) {

		Double p1 = Double.valueOf(n1.toString());
		Double p2 = Double.valueOf(n2.toString());

		Pattern p = Pattern.compile("-");
		Matcher m = p.matcher(op.toString());
		if (m.matches())
			return (p1 - p2) + "";

		m = Pattern.compile("\\+").matcher(op.toString());
		if (m.matches())
			return (p1 + p2) + "";

		p = Pattern.compile("/");
		m = p.matcher(op.toString());
		if (m.matches())
			return (p1 / p2) + "";

		return ((p1 * p2)) + "";
	}
}
