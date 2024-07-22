package algoexpert.Sorting;


import java.util.*;

/*
  Write a function that takes in an array of integers and returns a sorted version of that array. Use the Insertion Sort algorithm to sort the array.

  If you're unfamiliar with Insertion Sort, we recommend watching the Conceptual Overview section of this question's video explanation before starting to code.
 */
class InsertionSort {

    public static int[] insertionSort(int[] array) {
        if ( array.length == 0){
            return new int[] {};
        }
        for ( int i = 1; i < array.length; i++){
            int j = i;
            while ( j > 0 && array[j] < array[j - 1]){
                swap(j, j - 1, array);
                j -= 1;
            }
        }
        return new int[] {};
    }
    public static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}