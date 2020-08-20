import org.junit.Assert;
import org.junit.jupiter.api.Test;


class ExcerciseTest {

	@Test
	void test() {
		Excercise a = new Excercise();

		int[] 
				intArray = new int[]{ 1,2,3,4,6,7,8,9,10 }; 
     	Assert.assertTrue(a.solution(intArray) == 5);
     	
     	
     	intArray = new int[]{ -1,0 }; 
     	Assert.assertTrue(a.solution(intArray) == 1);
     	
     	intArray = new int[]{ -2,-1 }; 
     	Assert.assertTrue(a.solution(intArray) == 1);
     	
     	intArray = new int[]{ 1,1,3,6,7,8,9,10 }; 
     	Assert.assertTrue(a.solution(intArray) == 2);
     	
     	intArray = new int[]{ 1,1,0, 4,6,7,8,9,10 }; 
     	Assert.assertTrue(a.solution(intArray) == 2);
     	
     	intArray = new int[]{ 1,2,3,4,6,7,8,9,10 }; 
     	Assert.assertTrue(a.solution(intArray) == 5);
		
	}

	
	
}
