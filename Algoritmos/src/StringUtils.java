public class StringUtils {

    String reverse(String s) {
        if (s.length() == 0) {
            return s;
        }
        return reverse(s.substring(1)) + s.charAt(0);
    }

    String reverseString(String s) {
        if (s.length() == 0) {
            return s;
        }
        return s.charAt(s.length() - 1) + reverseString(s.substring(0, s.length() - 1));
    }

}
