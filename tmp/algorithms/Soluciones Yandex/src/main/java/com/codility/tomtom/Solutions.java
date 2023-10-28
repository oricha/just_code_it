import java.math.BigInteger;

public class Solutions {

	public static int resolver(final int[] A) {

		boolean[] visited = new boolean[A.length];
		int index = 0;
		int steps = 0;

		while (!visited[index]) {
			visited[index] = true; // mark index as visited

			try {
				index = A[A[index]];
			} catch (Exception E) {
				steps++; // count this step
			}

		}

		// result = Length - visited.count
		return A.length - steps;
	}

	public static int nada(int N) {
		BigInteger number = factorial(N);
		BigInteger result = sumOfDigits(number);
		return result.intValue();
	}

	public static BigInteger factorial(int number) {
		BigInteger factorial = BigInteger.ONE;
		for (int i = number; i > 0; i--) {
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		return factorial;

	}

	private static BigInteger sumOfDigits(BigInteger n) {
		BigInteger sum = BigInteger.ZERO;
		while (n.compareTo(BigInteger.ZERO) == 1) {
			sum = sum.add(n.remainder(BigInteger.TEN));
			n = n.divide(BigInteger.TEN);
		}
		return sum;
	}
}
