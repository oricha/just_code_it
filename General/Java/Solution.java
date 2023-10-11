/**
 * Problem Definition
 * Given a list of integers, identify sequences where successive numbers exactly N indexes
 * apart have a value equal to N multiplied by the previous number in the sequence.
 * Rules
 * • N must be greater than 1
 * • Sequences with less than 3 entries should be ignored
 * • Sequences returned must always be the longest possible for a given value of N
 * o In other words, there is max one resulting sequence for any value of N
 * o If there are multiple sequences for a single value of N then only return one of
 * them – you can choose any as long as your solution is deterministic
 *
 * • Sequences of all zeros do not count as valid sequences
 * • Sequences should be returned in order of the first element in the sequence
 * Example
 * Consider the following list of integers:
 *
 * Number 2 10 4 3 8 6 9 9 18 27
 * Index 0 1 2 3 4 5 6 7 8 9
 *
 * The following sequences are found:
 * • 2, 4, 8 (for N=2)
 * • 3, 9, 27 (for N=3)
 */

import java.util.*;
public class Solution {

    /**Write a Kotlin or Java program that accepts a list of Integers as an argument and returns a
     list of sequences matching the required pattern, with each sequence being a list.
     The method signature must be as follows:
     List<List<Integer>> findSequences(List<Integer> input)
     */

    public List<List<Integer>> findSequences(List<Integer> input){
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            int iterator = input.get(i);
            for (int j = i + 1; j < input.size(); j++) {
                int nextIterator = input.get(j);
                if (nextIterator == iterator * (j - i)) {
                    List<Integer> sequence = new ArrayList<>();
                    sequence.add(iterator);
                    sequence.add(nextIterator);
                    int k = j + 1;
                    while (k < input.size()) {
                        int p = input.get(k);
                        if (p == nextIterator * (k - j)) {
                            sequence.add(p);
                            nextIterator = p;
                            k++;
                        } else {
                            break;
                        }
                    }
                    if (sequence.size() >= 3) {
                        result.add(sequence);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        SequenceFinder sequenceFinder = new Solution();

        List<Integer> input = Arrays.asList(2, 10, 4, 3, 8, 6, 9, 9, 18, 27);

        List<List<Integer>> result = sequenceFinder.findSequences(input);
        System.out.println("Found sequences:");
        for(List<Integer> sequence : sequences){
            System.out.println(sequence);
        }
    }
}