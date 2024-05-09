
import java.util.*;


//Write a function that takes in a non-empty array of integers and returns the maximum sum
//that can be obtained by summing up all of the integers in a non-empty subarray of the input array.
//A subarray must only contain adjacent numbers (numbers next to each other in the input array).


class KadanAlgorithm {
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
