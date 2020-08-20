package com.zalando;

public class Solution1 {

	public int solution(int N) {
       
		int i = 10;
		int sum = 0;
		int d1 = N %10;
		int d2 = N / 10;
		
		
		//N = N + 9;
		
		while(N  != 0) {
			sum += N %10;
			N = N / 10;
		}
		
		return sum;
    }
}
