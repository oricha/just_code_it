package algoexpert.arrays;

import java.util.*;


/*
Sorted Squared Array
Write a function that takes in a non-empty array of integers that are sorted in ascending order and returns a
new array of the same length with the squares of the original integers also sorted in ascending order.
 Sample Input
    array = [1, 2, 3, 5, 6, 8, 9]
    Sample Output
    [1, 4, 9, 25, 36, 64, 81]*/

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

    public int[] sortedSquaredArray2(int[] array) {
        // Write your code here.
        int[] squaredArray =  new int[array.length];
        for ( int idx = 0; idx < array.length; idx++){
            int value = array[idx];
            squaredArray[idx] =  Math.abs(value * value);
        }
        Arrays.sort(squaredArray);
        return squaredArray;
    }

}