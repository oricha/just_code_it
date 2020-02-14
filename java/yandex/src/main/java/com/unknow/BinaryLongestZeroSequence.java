package com.unknow;

public class BinaryLongestZeroSequence {

	/**
	 * worst-case time complexity is O(log(N)); number of bits = log(N) ==>
	 * worst case is O(N)
	 * 
	 * @param N
	 * @return
	 */
	public int solution(int N) {
		// write your code in Java SE 8
		// System.out.println("input: " + N);

		String binaryString = Integer.toBinaryString(N);
		char[] binaries = binaryString.toCharArray();

		boolean startedSequence = false;

		int currentLength = -1;
		int maxLength = 0;

		for (char bit : binaries) {
			// System.out.print(bit + " ");

			if (bit == '0') {
				if (startedSequence) {
					currentLength++;
				}
			} else if (bit == '1') {
				if (startedSequence == false) {
					startedSequence = true;
				} else {
					if (maxLength < currentLength) {
						maxLength = currentLength;
					}
				}
				currentLength = 0;

			}
		}

		// System.out.println("Length for "+ N + " is " + maxLength);
		return maxLength;
	}

	public static void main(String[] args) {

		BinaryLongestZeroSequence algo = new BinaryLongestZeroSequence();

		validate(algo, 1041, 5);

		validate(algo, 8, 0);
		validate(algo, 529, 4);
		validate(algo, 20, 1);
		validate(algo, 15, 0);
		validate(algo, 9, 2);

	}

	private static void validate(BinaryLongestZeroSequence algo, int N,
			int sequenceLength) {
		System.out.println("==========");

		if (sequenceLength == algo.solution(N))
			System.out.println("PASS " + N);
		else
			System.out.println("FAIL " + N);

	}

}
