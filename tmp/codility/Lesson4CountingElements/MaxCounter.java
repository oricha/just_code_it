


package codility.Lesson4CountingElements;

import java.util.Arrays;

/**
 * You are given N counters, initially set to 0, and you have two possible operations on them:
 * <p>
 * increase(X) − counter X is increased by 1,
 * max counter − all counters are set to the maximum value of any counter.
 * A non-empty array A of M integers is given. This array represents consecutive operations:
 * <p>
 * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
 * if A[K] = N + 1 then operation K is max counter.
 * For example, given integer N = 5 and array A such that:
 * <p>
 * A[0] = 3
 * A[1] = 4
 * A[2] = 4
 * A[3] = 6
 * A[4] = 1
 * A[5] = 4
 * A[6] = 4
 * the values of the counters after each consecutive operation will be:
 * <p>
 * (0, 0, 1, 0, 0)
 * (0, 0, 1, 1, 0)
 * (0, 0, 1, 2, 0)
 * (2, 2, 2, 2, 2)
 * (3, 2, 2, 2, 2)
 * (3, 2, 2, 3, 2)
 * (3, 2, 2, 4, 2)
 * The goal is to calculate the value of every counter after all operations.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int N, int[] A); }
 * <p>
 * that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.
 * <p>
 * Result array should be returned as an array of integers.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 3
 * A[1] = 4
 * A[2] = 4
 * A[3] = 6
 * A[4] = 1
 * A[5] = 4
 * A[6] = 4
 * the function should return [3, 2, 2, 4, 2], as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N and M are integers within the range [1..100,000];
 * each element of array A is an integer within the range [1..N + 1].
 */
public class MaxCounters {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MaxCounters().solution(5, new int[]{3, 4, 4, 6, 1, 4, 4})));
    }

    public int[] solution(int N, int[] A) {
        int[] result = new int[N];
        int max = 0; // increase Variable to store the maximum value when calculating
        int allMax = 0; // max When calculating, max will be put here

        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1) {    // max
                allMax = max; // Maximum value stored
            } else {    //increase
                result[A[i] - 1] = Math.max(allMax, result[A[i] - 1]) + 1; // Increased by 1
                max = Math.max(max, result[A[i] - 1]);
            }
        }

        for (int i = 0; i < N; i++) {
            result[i] = Math.max(result[i], allMax);
        }
        return result;
    }
}
