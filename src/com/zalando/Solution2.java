package com.zalando;

public class Solution2 {

	public int solution(int[] A, int[] B) {

		int sumA = 0;
		int sumB = 0;
		for (int i = 0; i < A.length; i++) {
			sumA += A[i];
			sumB += B[i];
		}

		if (sumA != sumB)
			return 0;

		int accA = 0;
		int accB = 0;
		int distA = sumA;
		int distB = sumB;
		int k = 0;
		for (int i = 0; i < A.length; i++) {
			accA += A[i];
			accB += B[i];
			distA = sumA - accA;
			distB = sumB - accB;
			if (accA == accB && distA == distB && i >= 1 && accA == distA) {
				k++;
			}
		}

		return k;
	}
}
