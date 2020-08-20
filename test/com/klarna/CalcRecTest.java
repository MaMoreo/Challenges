package com.klarna;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.klarna.Calc.Stack;

class CalcRecTest {

	@Test
	void test() {
		final double DELTA = 0;
		CalcRec calculator = new CalcRec();
		
		
		assertEquals(5, calculator.evaluate("1 2 + 1 2 * +"), DELTA);
		
		assertEquals(0.0, calculator.evaluate("2.0 + 2"), DELTA);
		
		assertEquals(0.0, calculator.evaluate("2.0 4 2"), DELTA);
		
		// assertEquals(0, calculator.evaluate("- * +"), DELTA); 
		
		assertEquals(4, calculator.evaluate("2.0 2.00 +"), DELTA); 
		
		assertEquals(1, calculator.evaluate("3 2 -"), DELTA); 
		
		assertEquals(3, calculator.evaluate("1 2 +"), DELTA); 
		
		assertEquals(14.0, calculator.evaluate("5 1 2 + 4 * + 3 -"), DELTA); 
		
		assertEquals(17, calculator.evaluate("5 1 2 + 4 * +"), DELTA); 
		
		
        
	}

}
