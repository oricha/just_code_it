/**
 *
 * Group Anagrams
 * Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.
 *
 * An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 *
 * Example 1:
 *
 * Input: strs = ["act","pots","tops","cat","stop","hat"]
 *
 * Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
 * Example 2:
 *
 * Input: strs = ["x"]
 *
 * Output: [["x"]]
 * Example 3:
 *
 * Input: strs = [""]
 *
 * Output: [[""]]
 * Constraints:
 *
 * 1 <= strs.length <= 1000.
 * 0 <= strs[i].length <= 100
 * strs[i] is made up of lowercase English letters.
 */

import java.util.*;

/**
 * Group Anagrams
 * Given an array of strings strs, group all anagrams together into sublists.
 * An anagram is a string that contains the exact same characters as another string, but in a different order.
 *
 * Example 1:
 * Input: strs = ["act","pots","tops","cat","stop","hat"]
 * Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
 */
class GroupAnagrams {
    /**
     * Groups anagrams together from an array of strings.
     *
     * @param strs Array of input strings.
     * @return A list of lists where each sublist contains anagrams.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map to store grouped anagrams. The key is a sorted version of the string.
        Map<String, List<String>> map = new HashMap<>();

        // Iterate through each string in the input array
        for (String str : strs) {

            char[] charArray = str.toCharArray(); // Convert string to char array
            Arrays.sort(charArray);  // and sort it
            String sortedStr = new String(charArray); // Convert back to string

            // If the sorted string is not in the map, add a new list
            map.putIfAbsent(sortedStr, new ArrayList<>());

            // Add the original string to the corresponding anagram group
            map.get(sortedStr).add(str);
        }

        // Return all grouped anagrams as a list of lists
        return new ArrayList<>(map.values());
    }

    /**
     * Example test cases.
     */
    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();

        // Example 1
        String[] input1 = {"act", "pots", "tops", "cat", "stop", "hat"};
        System.out.println(solution.groupAnagrams(input1));

        // Example 2
        String[] input2 = {"x"};
        System.out.println(solution.groupAnagrams(input2));

        // Example 3
        String[] input3 = {""};
        System.out.println(solution.groupAnagrams(input3));
    }

}



/**
 * Explanation of the Solution
 * 	1.	Use a HashMap (Map<String, List<String>>) to store anagram groups.
 * 	•	The key is the sorted version of the word.
 * 	•	The value is a list of words that share the same sorted key.
 * 	2.	Iterate through the input array:
 * 	•	Convert each string into a character array.
 * 	•	Sort the array to get a unique key for anagrams.
 * 	•	Convert the sorted array back to a string key.
 * 	•	Add the original string to the corresponding group in the HashMap.
 * 	3.	Return the values of the HashMap as a list of lists.
 * 	•	Each list represents a group of anagrams.
 * 		•	Sorting each string takes O(k log k), where k is the length of the string.
 * 	•	Iterating over n words takes O(n).
 * 	•	Overall Complexity: O(n * k log k), which is efficient for large inputs.
 * 	Complexity Analysis:
 * 	•	Time complexity: O(n * k log k), where n is the number of words in the input array and k is the length of the longest word.
 * 	•	Space complexity: O(n * k), where n is the number of words in the input array and k is the length of the longest word.
 */