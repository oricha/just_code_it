
import java.util.*;


class ValidPalindrome {
    public boolean isPalindrome(String s) { // Remove non-alphanumeric characters and convert to lowercase
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        // Initialize pointers for the start and end of the string
        int left = 0, right = s.length() - 1;

        // Check characters from both ends towards the center
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public boolean isPalindrome2(String s) {
        s = s.replaceAll ( "[^A-Za-z0-9]", "").toLowerCase();

        int  left = 0 , right = s.length() - 1;
        while ( left < right ){
            if ( s.chartAt(left ) != s.chartAt(right)){
                return false;
            }
            left++;
            right--;

        }
        return true;
    }
}