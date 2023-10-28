package algoexpert.arrays;

//Smallest Difference
//Write a function that takes in two non-empty arrays of integers, finds the pair of numbers (one from each array)
//whose absolute difference is closest to zero, and returns an array containing these two numbers, with the
//number from the first array in the first position.
//
//Note that the absolute difference of two integers is the distance between them on the real number line.
//For example, the absolute difference of -5 and 5 is 10, and the absolute difference of -5 and -4 is 1.
//
//You can assume that there will only be one pair of numbers with the smallest difference.

/*
Smallest Difference
Write a function that takes in two non-empty arrays of integers, finds the pair of numbers (one from each array) whose
absolute difference is closest to zero, and returns an array containing these two numbers, with the number from the first
array in the first position.

Note that the absolute difference of two integers is the distance between them on the real number line. For example,
the absolute difference of -5 and 5 is 10, and the absolute difference of -5 and -4 is 1.

You can assume that there will only be one pair of numbers with the smallest difference.*/

import java.util.*;

class Program {
    // O(nlog(n) + mlog(m)) time | O(1) space
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int idxOne = 0;
        int idxTwo = 0;
        int smallest = Integer.MAX_VALUE;
        int current = Integer.MAX_VALUE;
        int[] smallestPair = new int[2];
        while (idxOne < arrayOne.length && idxTwo < arrayTwo.length) {
            int firstNum = arrayOne[idxOne];
            int secondNum = arrayTwo[idxTwo];
            if (firstNum < secondNum) {
                current = secondNum - firstNum;
                idxOne++;
            } else if (secondNum < firstNum) {
                current = firstNum - secondNum;
                idxTwo++;
            } else {
                return new int[]{firstNum, secondNum};
            }
            if (smallest > current) {
                smallest = current;
                smallestPair = new int[]{firstNum, secondNum};
            }
        }
        return smallestPair;
    }
}
