import java.io.*;
import java.util.*;

class Solution {


    static int[][] findPairsWithGivenDifference(int[] arr, int k) {

        ArrayList<int[]> result = new ArrayList<>();
        HashMap<Integer, Integer> hash = new HashMap<>();
        for( int i= 0; i < arr.length; i++){
            hash.put(arr[i] - k, arr[i]);
        }

        for( int x : arr){
            if( hash.containsKey(x)){
                result.add(new int [] {hash.get(x), x});
            }
        }

        int [][] returnArray = new int[result.size()][2];
        for( int i = 0; i < result.size(); i++){
            returnArray [i]= result.get(i);
        }
        return returnArray;
    }

    public static void main(String[] args) {
        int [] arr = new int[] {0, -1, -2, 2, 1};
        System.out.println(Arrays.deepToString(findPairsWithGivenDifference(arr, 1)));
    }

}
