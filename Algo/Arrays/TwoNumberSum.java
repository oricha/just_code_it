import java.util.*;


/*  Write a function that takes in a non-empty array of distinct integers and an
  integer representing a target sum. If any two numbers in the input array sum
  up to the target sum, the function should return them in an array, in any
  order. If no two numbers sum up to the target sum, the function should return
  an empty array.

  Note that the target sum has to be obtained by summing two different integers
  in the array; you can't add a single integer to itself in order to obtain the
  target sum.*/



class Program {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        Set<Integer> nums = new HashSet<>();
            for (int num : array) {
              int potentialMatch = targetSum - num;
              if (nums.contains(potentialMatch)) {
                return new int[] {potentialMatch, num};
              } else {
                nums.add(num);
              }
            }
            return new int[0];
        }
}