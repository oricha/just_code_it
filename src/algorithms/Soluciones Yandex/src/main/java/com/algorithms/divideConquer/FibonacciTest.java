import org.junit.Test;

import java.math.BigInteger;

/**
 * Fibonacci recursion. Solves the problem in exponential O
 *
 * codility excersice
 */
public class FibonacciTest {
	@Test
	public void test() throws InterruptedException {
		System.out.println(calculate(50));
	}

	public BigInteger calculate(int n) throws InterruptedException {
		if (Thread.interrupted())
			throw new InterruptedException();
		if (n < 0)
			throw new IllegalArgumentException();
		// System.out.println("Current n: " + n);
		if (n == 0)
			return BigInteger.ZERO;
		if (n == 1)
			return BigInteger.ONE;
		// Here for 10 the first calculate will be called 10 times, the second -
		// 9 times.
		return calculate(n - 1).add(calculate(n - 2));
	}
}
