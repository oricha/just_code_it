package com.codility;

/**
 * Lets say you have array A[0]=1 A[1]=-1 ....A[n]=x
 * 
 * Then what would be the smartest way to find out the number of times when
 * A[i]+A[j] is even where i < j
 * 
 * So if we have {1,2,3,4,5} we have 1+3 1+5 2+4 3+5 = 4 pairs which are even
 * 
 * @author Zion
 *
 */
public class SumEven {

	public static int sumEven(int[] A) {
		int sum = 0;

		int odd = 0;
		int even = 0;
		for (int j = 0; j < A.length; j++) {
			if (A[j] % 2 == 0) {
				sum += even;
				even++;
			} else {
				sum += odd;
				odd++;
			}
		}
		return sum;
	}

}
