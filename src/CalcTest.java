import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalcTest {

	@Test
	void testEvaluate() {
		
		Calc calculator = new Calc();
		
		 assertEquals(3, calculator.evaluate("1 2.5 +")); 
		
        assertEquals(3, calculator.evaluate("12+"));  	
	}

}
