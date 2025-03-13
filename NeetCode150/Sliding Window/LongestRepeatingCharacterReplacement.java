/**
 *Longest Repeating Character Replacement
 * You are given a string s consisting of only uppercase english characters and an integer k. You can choose up to k characters of the string and replace them with any other uppercase English character.
 *
 * After performing at most k replacements, return the length of the longest substring which contains only one distinct character.
 *
 * Example 1:
 *
 * Input: s = "XYYX", k = 2
 *
 * Output: 4
 * Explanation: Either replace the 'X's with 'Y's, or replace the 'Y's with 'X's.
 *
 * Example 2:
 *
 * Input: s = "AAABABB", k = 1
 *
 * Output: 5
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * 0 <= k <= s.length
 */

import java.util.*;

/**
 * Longest Repeating Character Replacement
 * Given a string s consisting of only uppercase English characters and an integer k,
 * return the length of the longest substring that contains only one distinct character
 * after performing at most k replacements.
 *
 * Example 1:
 * Input: s = "XYYX", k = 2
 * Output: 4
 *
 * Example 2:
 * Input: s = "AAABABB", k = 1
 * Output: 5
 */

class LongestRepeatingCharacterReplacement {
    /**
     * Finds the longest substring that can be made uniform by replacing at most k characters.
     *
     * @param s Input string consisting of uppercase letters.
     * @param k Number of replacements allowed.
     * @return Length of the longest valid substring.
     */
    public int characterReplacement(String s, int k) {
        // Frequency array to store character counts in the current window
        int[] freq = new int[26];
        int maxFreq = 0; // Most frequently occurring character in the window
        int left = 0; // Left boundary of the sliding window
        int maxLength = 0;

        // Expand the window with the right pointer
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            freq[currentChar - 'A']++; // Increment frequency count for this character
            maxFreq = Math.max(maxFreq, freq[currentChar - 'A']); // Update max frequency

            // Window size is (right - left + 1), maxFreq is the most common character count
            // If more than k characters need to be replaced, shrink window
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--; // Remove leftmost character from window
                left++; // Shrink window from the left
            }

            // Update maximum length found
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    /**
     * Example test cases.
     */
    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();

        // Example 1
        String s1 = "XYYX";
        int k1 = 2;
        System.out.println(solution.characterReplacement(s1, k1)); // Output: 4

        // Example 2
        String s2 = "AAABABB";
        int k2 = 1;
        System.out.println(solution.characterReplacement(s2, k2)); // Output: 5

        // Example 3
        String s3 = "ABAB";
        int k3 = 2;
        System.out.println(solution.characterReplacement(s3, k3)); // Output: 4

        // Example 4
        String s4 = "AABABBA";
        int k4 = 1;
        System.out.println(solution.characterReplacement(s4, k4)); // Output: 4
    }
}

/**
 *  Explanation of the Solution
 * 	1.	Use a HashMap (Map<Character, Integer>) to store the count of each character.
 * 	•	The key is the character, and the value is the count of that character.
 * 	2.	Use a variable maxCount to track the maximum count of any character.
 * 	3.	Use a variable maxLength to track the length of the longest substring.
 * 	4.	Iterate through the input string:
 * 	•	Update the count of the current character in the HashMap.
 * 	•	Update maxCount to be the maximum of the current count and maxCount.
 * 	•	Update maxLength to be the maximum of the current length and maxLength.
 * 	5.	Return maxLength.
 * 	Complexity Analysis:
 * 	•	Time complexity: O(n), where n is the length of the input string.
 * 	•	Space complexity: O(k), where k is the number of unique characters in the input string.
 */