package algoexpert.Sorting;


import java.util.*;

/*
Bubble Sort
Write a function that takes in an array of integers and returns a sorted version of that array. Use the Bubble Sort algorithm to sort the array.

If you're unfamiliar with Bubble Sort, we recommend watching the Conceptual Overview section of this question's video explanation before starting to code.

Sample Input
array = [8, 5, 2, 9, 5, 6, 3]
Sample Output
[2, 3, 5, 5, 6, 8, 9]
 */

class BubbleSorting {
    public static int[] bubbleSort(int[] array) {
        // Write your code here.
        boolean isSorted = false;
        int counter = 0;
        while(!isSorted){
            isSorted =  true;
            for( int i = 0 ; i < array.length - 1 ;  i++){
                if ( array[i] > array[i+1]){
                    swap( i, i+ 1, array);
                    isSorted =  false;
                }
            }
        }
        return array;
    }

    /* O(n^2) time | O(1) space*/
    public static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}