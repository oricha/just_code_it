/**
 * Valid Palindrome
 * Given a string s, return true if it is a palindrome, otherwise return false.
 *
 * A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.
 *
 * Example 1:
 *
 * Input: s = "Was it a car or a cat I saw?"
 *
 * Output: true
 * Explanation: After considering only alphanumerical characters we have "wasitacaroracatisaw", which is a palindrome.
 *
 * Example 2:
 *
 * Input: s = "tab a cat"
 *
 * Output: false
 * Explanation: "tabacat" is not a palindrome.
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s is made up of only printable ASCII characters.
 */

class ValidPalindrome {

    public boolean isPalindrome(String s) {
        // Step 1: Remove all non-alphanumeric characters and convert the string to lowercase.
        // This ensures that we only compare letters and numbers, ignoring case and symbols.
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        // Step 2: Initialize two pointers, one at the start and one at the end of the string.
        int left = 0;
        int right = s.length() - 1;

        // Step 3: Use a while loop to compare characters from both ends towards the center.
        while (left < right) {
            // If characters at the current pointers don't match, it's not a palindrome.
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            // Move the left pointer to the right and the right pointer to the left.
            left++;
            right--;
        }

        // Step 4: If all characters matched, the string is a palindrome.
        return true;
}