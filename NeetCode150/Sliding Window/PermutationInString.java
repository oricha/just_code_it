/**
 *Permutation in String
 * You are given two strings s1 and s2.
 *
 * Return true if s2 contains a permutation of s1, or false otherwise. That means if a permutation of s1 exists as a substring of s2, then return true.
 *
 * Both strings only contain lowercase letters.
 *
 * Example 1:
 *
 * Input: s1 = "abc", s2 = "lecabee"
 *
 * Output: true
 * Explanation: The substring "cab" is a permutation of "abc" and is present in "lecabee".
 *
 * Example 2:
 *
 * Input: s1 = "abc", s2 = "lecaabee"
 *
 * Output: false
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 1000
 */

import java.util.*;

/**
 * Permutation in String
 * Given two strings s1 and s2, return true if s2 contains any permutation of s1.
 * That means a permutation of s1 must appear as a substring in s2.
 *
 * Example 1:
 * Input: s1 = "abc", s2 = "lecabee"
 * Output: true
 *
 * Example 2:
 * Input: s1 = "abc", s2 = "lecaabee"
 * Output: false
 */

class PermutationInString {
    /**
     * Checks if s2 contains a permutation of s1.
     *
     * @param s1 The smaller string whose permutation is to be checked.
     * @param s2 The larger string where the permutation might exist.
     * @return True if any permutation of s1 is a substring of s2, otherwise false.
     */
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length(), s2Len = s2.length();
        if (s1Len > s2Len) return false; // Edge case: s1 can't be in s2 if it's longer

        // Frequency arrays for character counts
        int[] s1Freq = new int[26]; // Stores frequency of characters in s1
        int[] s2Freq = new int[26]; // Stores frequency of characters in current window of s2

        // Populate s1 frequency count
        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        // Sliding window approach
        for (int i = 0; i < s2Len; i++) {
            // Add current character in window
            s2Freq[s2.charAt(i) - 'a']++;

            // Remove the character that is sliding out of the window
            if (i >= s1Len) {
                s2Freq[s2.charAt(i - s1Len) - 'a']--;
            }

            // Compare window with s1 frequency array
            if (Arrays.equals(s1Freq, s2Freq)) return true;
        }

        return false;
    }

    /**
     * Example test cases.
     */
    public static void main(String[] args) {
        PermutationInString solution = new PermutationInString();

        // Example 1
        String s1 = "abc";
        String s2 = "lecabee";
        System.out.println(solution.checkInclusion(s1, s2)); // Output: true

        // Example 2
        String s3 = "abc";
        String s4 = "lecaabee";
        System.out.println(solution.checkInclusion(s3, s4)); // Output: false

        // Example 3
        String s5 = "a";
        String s6 = "b";
        System.out.println(solution.checkInclusion(s5, s6)); // Output: false

        // Example 4
        String s7 = "ab";
        String s8 = "eidbaooo";
        System.out.println(solution.checkInclusion(s7, s8)); // Output: true
    }
}

/**
 * Explanation of the Solution
 * 	1.	Use Frequency Arrays (s1Freq and s2Freq)
 * 	•	Track character counts for s1 and a sliding window of length s1.length() in s2.
 * 	2.	Sliding Window Approach
 * 	•	Expand window by adding the new character.
 * 	•	Shrink window by removing the leftmost character (when window size > s1.length()).
 * 	•	If s1Freq matches s2Freq, a permutation exists → return true.
 * 	3.	Why Compare Arrays?
 * 	•	If the frequency count of s1 matches any window in s2, then a permutation exists.
 * 	4.	Time Complexity
 * 	•	Sliding Window: O(n)
 * 	•	Frequency Arrays: O(26)
 * 	•	Total: O(n + 26)
 * 	5.	Space Complexity
 * 	•	Frequency Arrays: O(26)
 * 	6.	Overall Complexity
 * 	•	Time Complexity: O(n + 26)
 * 	•	Space Complexity: O(26)
 * 	Complexity Analysis:
 * 	•	Time complexity: O(n + 26), where n is the length of the input strings.
 * 	•	Space complexity: O(26), where 26 is the number of unique characters in the input strings.
 */