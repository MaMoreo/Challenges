import java.util.Arrays;

public class Excercise {

	public int solution2(int[] A) {
	        // write your code in Java SE 8
		 Arrays.sort(A);
		    int count = 1;
		    if (A[A.length -1 ] < 0)
		    return 1;
		    
			for(int i =0; i < A.length; i++) {
				if (A[i] == count) {
					continue;
				} if (A[i] == count + 1) {
				    count ++;
				    continue;
				}
				break;
			
	    }
			return count + 1;
	}

	public int solution(int[] A) {
		        // write your code in Java SE 8
			 Arrays.sort(A);
			    int count = 1;
			   
			    
				for(int i =0; i < A.length; i++) {
					if (A[i] < count) {
						continue;
					} else if (A[i] == count) {
						count ++;
					    
					}
		    }
				return count;
				
	}	
}
