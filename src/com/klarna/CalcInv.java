package com.klarna;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Your job is to create a calculator which evaluates expressions in Reverse
 * Polish notation.
 * 
 * For example expression 5 1 2 + 4 * + 3 - (which is equivalent to 5 + ((1 + 2)
 * * 4) - 3 in normal notation) should evaluate to 14.
 * 
 * Note that for simplicity you may assume that there are always spaces between
 * numbers and operations, e.g. 1 3 + expression is valid, but 1 3+ isn't.
 * 
 * Empty expression should evaluate to 0.
 * 
 * Valid operations are +, -, *, /.
 * 
 * You may assume that there won't be exceptional situations (like stack
 * underflow or division by zero).
 */
public class CalcInv {

	// TODO: check the link in WK, use Polish Notation (No reverse) -> queue
	// ?‚
	// TODO: compare with java.util.Stack
	Stack stack;

	public double evaluate(String expr) {

		if (expr.isEmpty())
			return 0;
		
		String[] digits = expr.split(" ");
		stack = new Stack(digits.length);
		
		

		for (int i = 0; i < digits.length; i++) {

			if (isNumber(digits[i])) {

				stack.put(digits[i]);

			} else { // is an operator
				if (!isNumber(stack.peek())) { // peek not a number

					stack.put(digits[i]);

				} else {

					// is a number
					String op = digits[i];
					String n2 = stack.pop();
					String n1 = stack.pop();
					if (!isNumber(n2) || !isNumber(n1)) {
						return Double.NaN;
					}
					stack.put(performOperation(n1, n2, op));
				}
			}
		}

		if (isNumber(stack.peek())) {
			Double result = Double.valueOf(stack.pop());
			return result;
		}

		return Double.NaN;
	}

	/*
	 * The stack
	 */
	class Stack {
		String[] stack;
		int head;

		Stack(int size) {
			stack = new String[size];
			head = -1;
		}

		Stack put(String value) {
			if ((head >= stack.length - 1)) {
				return this;
			}

			head++;
			stack[head] = value;
			return this;
		}

		String peek() {
			if (isEmpty())
				return "";

			return stack[head];
		}

		String pop() {
			if (isEmpty()) {
				return ""; // FIXME: StringUtils.EMPTY ?
			}

			String value = stack[head];
			stack[head] = null; // nullify the value
			head--;
			return value;
		}

		boolean isEmpty() {
			return (head == -1) ? true : false;
		}
	}

	private boolean isNumber(String a) {
		Pattern p = Pattern.compile("-?\\d[\\.\\d]*"); // numbers with decimals
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
