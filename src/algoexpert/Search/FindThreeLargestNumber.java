
package algoexpert.Search;


import java.util.*;

/*
Write a function that takes in an array of at least three integers and, without sorting the input array, returns a sorted array of
the three largest integers in the input array.

The function should return duplicate integers if necessary; for example, it should return [10, 10, 12] for an input array of [10, 5, 9, 10, 12].
Sample Input
array = [141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7]
Sample Output
[18, 141, 541]
 */
class FindThreeLargestNumber {

    public static int[] findThreeLargestNumbers(int[] array) {
         int [] threeLargest = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
         for ( int num : array){
             updateLargest(threeLargest, num);
         }
        return threeLargest;
    }

    public static void updateLargest(int[] threeLargest, int num){
        if ( num > threeLargest[2]){
            shiftAndUpdate(threeLargest, num, 2);
        } else if ( num > threeLargest[1]){
            shiftAndUpdate(threeLargest, num, 1);
        } else if ( num > threeLargest[0]){
            shiftAndUpdate(threeLargest, num, 0);
        }
    }

    // shift the array to the left and update the value at the index
    public static void shiftAndUpdate(int[] array, int num, int index){
        for ( int i = 0; i <= index; i++){
            if ( i == index){
                array[i] = num;
            } else {
                array[i] = array[i + 1];
            }
        }
    }
}

