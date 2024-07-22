package algoexpert.arrays;

import java.util.*;


/*Validate Subsequence
Given two non-empty arrays of integers, write a function that determines whether the second array is a subsequence of the first one.

A subsequence of an array is a set of numbers that aren't necessarily adjacent in the array but that are in the same
order as they appear in the array. For instance, the numbers [1, 3, 4] form a subsequence of the array [1, 2, 3, 4],
and so do the numbers [2, 4]. Note that a single number in an array and the array itself are both valid subsequences of the array.

    Sample Input
    array = [5, 1, 22, 25, 6, -1, 8, 10]
    sequence = [1, 6, -1, 10]
    Sample Output
    true*/

class ValidateSubsequence {
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int arrIdx = 0;
        int seqIdx = 0;
        while ( arrIdx < array.size() && seqIdx < sequence.size()) {
            if(array.get(arrIdx).equals(sequence.get(seqIdx))){
                seqIdx++;
            }
            arrIdx++;
        }
        return seqIdx == sequence.size();
    }

    public static boolean isValidSubsequence2(List<Integer> array, List<Integer> sequence) {
        int sedIdx = 0;
        for ( int value : array) {
            if ( sedIdx == sequence.size()) { // if we have already found all the elements in the sequence  then break
                break;
            }
            if ( sequence.get(sedIdx).equals(value)) { // if the value in the array is equal to the value in the sequence
                sedIdx++;
            }
        }
        return sedIdx == sequence.size();
    }
}