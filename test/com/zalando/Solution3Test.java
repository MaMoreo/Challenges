package com.zalando;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Solution3Test {

	@Test
	void test() {
		Solution3 s3 = new Solution3();
		
		int U = 1;
		int L = 1;
		int[] C = new int [] {1, 0};
		assertTrue("IMPOSSIBLE".equals(s3.solution(U, L, C)));  
		
		U = 3;
		L = 2;
		C = new int [] {1, 0, 2, 2};
		assertTrue("1011,0011".equals(s3.solution(U, L, C)));
		
		U = 0;
		L = 2;
		C = new int [] {0, 0, 0, 2};
		assertTrue("IMPOSSIBLE".equals(s3.solution(U, L, C)));
	
		U = 0;
		L = 1;
		C = new int [] {0, 0, 0, 1};
		assertTrue("0000,0001".equals(s3.solution(U, L, C)));
		
		U = 0;
		L = 0;
		C = new int [] {0, 0, 0, 0};
		assertTrue("0000,0000".equals(s3.solution(U, L, C)));
	}

}
