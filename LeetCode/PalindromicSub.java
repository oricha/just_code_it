

//
//Finding the longest palindromic substring is a classic problem of coding interview.
//        In this post, I will summarize 3 different solutions for this problem.


public class PalindromicSub {

    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String substring = helperMethod(s, i, i);
            if (substring.length() > longest.length()) {
                longest = substring;
            }
            // get longest palindrome with center of i, i+1
            substring = helperMethod(s, i, i + 1);
            if (substring.length() > longest.length()) {
                longest = substring;
            }
        }
        return longest;
    }

    // Given a center, either one letter or two letter,
// Find longest palindrome
    public String helperMethod(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }

    public static void main(String[] args) {
        var solution = new PalindromicSubstring();
        var example = "abba";
        System.out.println(solution.countSubstrings(example));  // Output: 6 (["a", "b", "b", "a", "bb", "abba"])
    }
}