import java.util.ArrayList;
import java.util.List;

/**
 * @author alisovenko
 *         2/26/16.
 */
public class RemoveInvalidParenthesis {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    public void remove(String s, List<String> ans, int last_i, int last_j, char[] par) {
        int stack = 0, i;
        for (i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack < 0) {
                for (int j = last_j; j <= i; ++j) {
                    if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
                        remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
                }
                return;
            }
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(')
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        else
            ans.add(reversed);
    }

    public static void main(String[] args) {
        System.out.println(new RemoveInvalidParenthesis().removeInvalidParentheses(")(()()))(()"));
    }

}
