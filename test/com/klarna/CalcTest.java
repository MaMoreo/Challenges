package com.klarna;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.klarna.Calc.Stack;

class CalcTest {
	
	
	private Calc calc = new Calc();

	@Test
	  public void shouldWorkForAnEmptyString() {
	    assertEquals(0, calc.evaluate(""), 0);
	  }
	  @Test
	  public void shouldParseNumbers() {
	    assertEquals(3, calc.evaluate("1 2 3"), 0);
	  }
	  @Test
	  public void shouldParseFloats() {
	    assertEquals(3.5, calc.evaluate("1 2 3.5"), 0);
	  }
	

	@Test
	public void testEvaluate() {
		
		
		final double DELTA = 0;
		
		assertEquals(20.0, calc.evaluate("5.0 5.00 5 5 + + +"), DELTA);
		
		assertEquals(0.0, calc.evaluate("5.0 5.00 5 + + +"), DELTA);
		
		assertEquals(2, calc.evaluate("4 2 /"), DELTA);
		
		assertEquals(0.0, calc.evaluate("2.0 + 2"), DELTA);
		
		assertEquals(0.0, calc.evaluate("2.0 4 2"), DELTA);
		
		assertEquals(7, calc.evaluate("1 2 3 * +"), DELTA);
		
		assertEquals(5, calc.evaluate("1 2 + 1 2 * +"), DELTA);
		
		assertEquals(0.0, calc.evaluate("/ * +"), DELTA); 
		
		assertEquals(4, calc.evaluate("2.0 2.00 +"), DELTA); 
		
	    assertEquals(4, calc.evaluate("8 2.00 /"), DELTA); 
		
		assertEquals(3, calc.evaluate("1 2 +"), DELTA); 
        
		assertEquals(0, calc.evaluate("1 2 + 3 -"), DELTA);  	
		
		assertEquals(14, calc.evaluate("5 1 2 + 4 * + 3 -"), DELTA); 
		
		assertEquals(0.0, calc.evaluate("2.0 2.00 2"), DELTA); 
		
		 
	}
	
	@Test
	void testStack() {
		
		Calc calculator = new Calc();
		Stack stack = calculator.new Stack(5);
		
		assertTrue(stack.isEmpty());
		stack.put("A");
		assertFalse(stack.isEmpty());
		assertEquals("A", stack.pop());
		assertTrue(stack.isEmpty());
		
		stack.put("A");
		stack.put("A");
		stack.put("A");
		stack.put("A");
		stack.put("A");
		stack.put("too much");
		assertNotEquals("too much", stack.peek());
		
	}
	
	@Test
	void testStackPeek() {
		
		Calc calculator = new Calc();
		Stack stack = calculator.new Stack(5);
		
		assertTrue(stack.isEmpty());
		assertEquals("", stack.peek());   // peek on an empty stack
		
		stack.put("A");
		assertFalse(stack.isEmpty());
		assertEquals("A", stack.peek());
		assertFalse(stack.isEmpty());
		assertEquals("A", stack.pop());
		assertTrue(stack.isEmpty());
		assertEquals("", stack.peek());
			
	}
}
