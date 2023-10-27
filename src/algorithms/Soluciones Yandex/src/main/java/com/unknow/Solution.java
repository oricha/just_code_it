public class Solution {

	static String toCamelCase(String s) {
		return "";
	}

	static public int solution(int[] A) {
		int result = Integer.MAX_VALUE;
		
		if (A.length == 2) {
			return Math.abs(A[0] - A[1]);
		}
		
		int[] sumRight = new int[A.length - 1];
		sumRight[0] = A[0];
		
		for (int i = 1; i < A.length - 1; i++) {
			sumRight[i] = sumRight[i - 1] + A[i];
		}

		int[] sumLeft = new int[A.length - 1];
		sumLeft[A.length - 2] = A[A.length - 1];
		for (int i = A.length - 3; i >= 0; i--) {
			sumLeft[i] = sumLeft[i + 1] + A[i + 1];
		}

		for (int j = 0; j < sumRight.length; j++) {
			int sum = Math.abs(sumRight[j] - sumLeft[j]);
			if (sum < result)
				result = sum;
		}
		return result;
	}
}
