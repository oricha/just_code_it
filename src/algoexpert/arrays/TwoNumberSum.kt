/*  Write a function that takes in a non-empty array of distinct integers and an
  integer representing a target sum. If any two numbers in the input array sum
  up to the target sum, the function should return them in an array, in any
  order. If no two numbers sum up to the target sum, the function should return
  an empty array.
.*/



fun twoNumberSum(array: MutableList<Int>, targetSum: Int): List<Int> {
    val nums = mutableMapOf<Int, Boolean>()
        for (num in array) {
            val potentialMatch = targetSum - num
            if (nums.containsKey(potentialMatch)) {
                return listOf<Int>(potentialMatch, num)
            } else {
                nums[num] = true
            }
        }
        return listOf<Int>()
}
