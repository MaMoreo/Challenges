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
public class Calc {

	// TODO: check the link in Wikipedia, use Polish Notation (No reverse) -> queue
	// ?‚
	// TODO: compare with java.util.Stack
	Stack stack;

	public double evaluate(String expr) {

		String[] digits = expr.split(" ");
		stack = new Stack(digits.length);
		
		for (int i = digits.length -1 ; i >= 0; i--) {

			
			if (isOperator(digits[i])) {
				
				stack.put(digits[i]);
			
			} else {  // is a number
				if (stack.isEmpty()) {
					return 0.0;
				}
				
				if( ! isNumber(stack.peek())) { // peek not a number
				
					stack.put(digits[i]);
			   
				}else { 
					
					// is a number
					String r  = digits[i];
					while (isNumber(stack.peek())){
						String n1 = r;
						String n2 = stack.pop();
						String op = stack.pop();
						if (!isNumber(n2) || !isOperator(op)) {
							return 0.0;  
						}
						r =  performOperation(n1, n2, op) ;
					}
			    	stack.put(r);
			      } 
			  }
		}
		
		if ( isNumber(stack.peek())) {
			 Double result = Double.valueOf(stack.pop());
			 if(stack.isEmpty())
				 return result;
		}
		
		return 0.0;
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
			if ( (head >= stack.length -1)) {
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
			stack[head] = null;  //nullify the value 
			head--;
			return value;
		}

		boolean isEmpty() {
			return (head == -1) ? true : false;
		}
	}

	private boolean isNumber(String a) {
		 Pattern p = Pattern.compile("\\d[\\.\\d]*");  // numbers with decimals
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
			  return  (p1 - p2)+"";
		
		 
	    m = Pattern.compile("\\+").matcher(op.toString());
		if (m.matches()) 
		  return (p1 + p2)+"";
		 
		
		p = Pattern.compile("/");
		m = p.matcher(op.toString());
		if (m.matches())
			 return (p1 / p2)+"";

		return ((p1 * p2))+"";
	}
}
