
import java.util.*;


//  Write a function that takes in an array of positive integers and returns the
//  maximum sum of non-adjacent elements in the array.
//  If the input array is empty, the function should return

class Program {
    public static int maxSubsetSumNoAdjacent(int[] array) {

        if( array.length == 0){
            return 0;
        } else if ( array.length == 1){
            return array[0];
        }
        int[] maxSums = array.clone();
        maxSums[1] = Math.max( array[0], array[1]);
        for( int i = 2; i < array.length; i++){
            maxSums[i] = Math.max(maxSums[i-1], maxSums[i-2] + array[i]);
        }
        return maxSums[array.length -1];
    }
}