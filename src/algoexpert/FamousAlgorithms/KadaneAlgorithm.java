package algoexpert.FamousAlgorithms;

import java.util.*;


/**
 * Write a function that takes in a non-empty array of integers and returns the maximum sum that can
 * be obtained by summing up all of the integers in a non-empty subarray of the input array.
 * A subarray must only contain adjacent numbers (numbers next to each other in the input array).
 *
 * Sample Input
 * array = [3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4]
 * Sample Output
 * 19 // [1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1]
 */
class Program {
    // O(n) time | O(1) space
    public static int kadanesAlgorithm(int[] array) {
        int maxEndingHere = array[0];
        int maxSoFar = array[0];
        for (int i = 1; i < array.length; i++) {
            int num = array[i];
            maxEndingHere = Math.max(num, maxEndingHere + num);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
