/**
 * Valid Anagram
 * Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
 *
 * An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
 *
 * Example 1:
 *
 * Input: s = "racecar", t = "carrace"
 *
 * Output: true
 * Example 2:
 *
 * Input: s = "jar", t = "jam"
 *
 * Output: false
 * Constraints:
 *
 * s and t consist of lowercase English letters.
 */

import java.util.HashMap;

class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        // If lengths are different, they can't be anagrams.
        if (s.length() != t.length()) {
            return false;
        }

        // Create a HashMap to store character frequencies.
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        // Iterate through both strings simultaneously.
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);  // Current character from string 's'
            char charT = t.charAt(i);  // Current character from string 't'

            // Increment count for the character from string 's'.
            charCountMap.put(charS, charCountMap.getOrDefault(charS, 0) + 1);

            // Decrement count for the character from string 't'.
            charCountMap.put(charT, charCountMap.getOrDefault(charT, 0) - 1);
        }

        // Check if all values in the map are zero.
        // If any count is non-zero, the strings are not anagrams.
        for (int count : charCountMap.values()) {
            if (count != 0) {
                return false;
            }
        }

        // If all counts are zero, the strings are anagrams.
        return true;
    }
}