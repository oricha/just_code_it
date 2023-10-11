

//Rotate Array in Java


//Problem: Rotate an array of n elements to the right by k steps. For example, with n = 7 and k = 3,
// the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
//How many different ways do you know to solve this problem?

public class Rotate {


    public void rotate(int[] nums, int k) {
        if (k > nums.length) {
            k = k % nums.length;
        }
        var result = new int[nums.length];  // Create new array

        for (int i = 0; i < k; i++) {  // Mode de las elements to the begining of the new array
            result[i] = nums[nums.length - k + i];
        }
        var j = 0;  //

        for (int i = k; i < nums.length; i++) { // Mode the rest of the elements to the end of the new array
            result[i] = nums[j];
            j++;
        }
        System.arraycopy(result, 0, nums, 0, nums.length);
    }

}