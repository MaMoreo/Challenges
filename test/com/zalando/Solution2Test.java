package com.zalando;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Solution2Test {

	@Test
	void test() {
		Solution2 s2 = new Solution2();

		// ([1, 4, 2, -2, 5], [7, -2, -2, 2, 5])

		// ([2, -2, -3, 3], [0, 0, 4, -4])

		int[] A = new int[] { 1, 4, 2, -2, 5 };
		int[] B = new int[] { 7, -2, -2, 2, 5 };
		assertEquals(2, s2.solution(A, B));

		A = new int[] { 2, -2, -3, 3 };
		B = new int[] { 0, 0, 4, -4 };
		assertEquals(2, s2.solution(A, B));
		
		A = new int[] { 4, -1, 0, 3 };
		B = new int[] { -2, 5, 0, 3 };
		assertEquals(2, s2.solution(A, B));
		
		A = new int[] { 4, -1, 0, 3 };
		B = new int[] { -2, 6, 0, 3 };
		assertEquals(0, s2.solution(A, B));
		
		A = new int[] { 3,2,6 };
		B = new int[] { 4,1,6 };
		assertEquals(0, s2.solution(A, B));
	}

}
