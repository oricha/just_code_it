import java.util.*;


//  Given two non-empty arrays of integers, write a function that determines
//  whether the second array is a subsequence of the first one.
//  A subsequence of an array is a set of numbers that aren't necessarily adjacent
//  in the array but that are in the same order as they appear in the array. For
//  instance, the numbers

class Program {
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
}