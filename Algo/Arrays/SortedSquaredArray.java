
import java.util.*;



/*  Write a function that takes in a non-empty array of integers that are sorted
  in ascending order and returns a new array of the same length with the squares
  of the original integers also sorted in ascending order.

 */

class SortedSquaredArray {

    public int[] sortedSquaredArray(int[] array) {
        // Write your code here.

        int[] sortedSquares = new int[array.length];
        for( int idx=0; idx < array.length; idx++){
            int value = array[idx];
            sortedSquares[idx] = value * value;
        }
        Arrays.sort(sortedSquares);
        return sortedSquares;
    }

}