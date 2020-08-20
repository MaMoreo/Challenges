package com.zalando;

public class Solution3 {

	public String solution(int U, int L, int[] C) {

		int sum = 0;
		for (int i = 0; i < C.length; i++) {
			sum += C[i];
		}

		if ((U + L) != sum)
			return "IMPOSSIBLE";

		StringBuilder row0 = new StringBuilder();
		StringBuilder row1 = new StringBuilder();
		for (int i = 0; i < C.length; i++) {
			if (C[i] == 2) {
				if (U > 0 && L > 0) {
					row0.append(1);
					row1.append(1);
					U--;
					L--;
				} else {
					return "IMPOSSIBLE";
				}
			}

			if (C[i] == 0) {
				row0.append(0);
				row1.append(0);
			}

			if (C[i] == 1) {
				if (U != 0) {
					row0.append(1);
					row1.append(0);
					U--;
				} else if (L != 0) {
					row0.append(0);
					row1.append(1);
					L--;
				} else {
					return "IMPOSSIBLE";
				}
			}
		}

		return row0.append(",").append(row1).toString();
	}
}
