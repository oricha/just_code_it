/**
 * Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 * Example 1:
 *
 * Input: s = "zxyzxyz"
 *
 * Output: 3
 * Explanation: The string "xyz" is the longest without duplicate characters.
 *
 * Example 2:
 *
 * Input: s = "xxxx"
 *
 * Output: 1
 * Constraints:
 *
 * 0 <= s.length <= 1000
 * s may consist of printable ASCII characters.
 *
 */

import java.util.*;

/**
 * Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without duplicate characters.
 * A substring is a contiguous sequence of characters within a string.
 *
 * Example 1:
 * Input: s = "zxyzxyz"
 * Output: 3
 * Explanation: The string "xyz" is the longest without duplicate characters.
 *
 * Example 2:
 * Input: s = "xxxx"
 * Output: 1
 */

class LongestSubstringWithoutRepeatingChar {
    /**
     * Finds the length of the longest substring without repeating characters.
     *
     * @param s Input string.
     * @return Length of the longest unique-character substring.
     */
    public int lengthOfLongestSubstring(String s) {
        // HashSet to track characters in the current window
        Set<Character> set = new HashSet<>();

        int left = 0; // Left boundary of the sliding window
        int maxLength = 0; // Stores the maximum length found

        // Expand the window with the right pointer
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If character is already in the set, move the left pointer to remove duplicates
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add new character to the set
            set.add(currentChar);

            // Update max length of substring
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    /**
     * Example test cases.
     */
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingChar solution = new LongestSubstringWithoutRepeatingChar();

        // Example 1
        String s1 = "zxyzxyz";
        System.out.println(solution.lengthOfLongestSubstring(s1)); // Output: 3

        // Example 2
        String s2 = "xxxx";
        System.out.println(solution.lengthOfLongestSubstring(s2)); // Output: 1

        // Example 3
        String s3 = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(s3)); // Output: 3

        // Example 4
        String s4 = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(s4)); // Output: 3
    }

    public int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for ( int right = 0; right < s.length() ; right++){ // puntero derecha
            char currentChar = s.charAt(right); // puntero izquierdo
            while ( set.contains(currentChar)){ // mientras el conjunto contenga el caracter actual
                set.remove(s.charAt(left));  // remueve el caracter de la izquierda
                left++; // incrementa el puntero izquierdo
            }

            set.add(currentChar); // agrega el caracter actual al conjunto
            maxLength = Math.max(maxLength, right - left + 1); // actualiza la longitud máxima
        }
        return maxLength;
    }


}

/**
 * Explanation of the Solution
 * 	1.	Use a HashSet (Set<Character>) to track unique characters in the window.
 * 	2.	Use a Sliding Window (left and right pointers):
 * 	•	Expand right to add characters.
 * 	•	If a duplicate appears, move left forward until the duplicate is removed.
 * 	3.	Update maxLength at each valid window expansion.
 * 	4.	Return maxLength.
 * 	Complexity Analysis:
 * 	•	Time complexity: O(n), where n is the length of the input string.
 * 	•	Space complexity: O(k), where k is the number of unique characters in the input string.
 */