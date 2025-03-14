import java.util.Arrays;

/**
 * @author alisovenko 24.01.15
 */
public class KnuttMorisPratt {
    void KMPSearch(String pattern, String text) {
        int M = pattern.length();
        int N = text.length();
        char[] pat = pattern.toCharArray();
        char[] txt = text.toCharArray();

        // create lps[] that will hold the longest prefix suffix values for pattern
        int[] lps = lps(pattern);

        int j = 0;  // index for pat[]
        int i = 0;  // index for txt[]

        while (i < N) {
            if (pat[j] == txt[i]) {
                j++;
                i++;
            }

            if (j == M) {
                System.out.printf("Found pattern at index %d \n", i - j);
                j = lps[j - 1];
            }

            // mismatch after j matches
            else if (i < N && pat[j] != txt[i]) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }

    int[] lps(String pattern) {
        char[] pat = pattern.toCharArray();

        int[] lps = new int[pat.length];

        int len = 0;  // lenght of the previous longest prefix suffix
        int i;

        lps[0] = 0; // lps[0] is always 0
        i = 1;

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < pat.length) {
            if (pat[i] == pat[len]) {
                len++;
                lps[i] = len;
                i++;
            } else // (pat[i] != pat[len])
            {
                if (len != 0) {
                    // This is tricky. Consider the example AAACAAAA and i = 7.
                    // (al) so here we decrease the "prefix" length and try the next character.
                    len = lps[len - 1];

                    // Also, note that we do not increment i here
                } else // if (len == 0)
                {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        System.out.println(Arrays.toString(lps));
        return lps;
    }

    public static void main(String[] args) {
        KnuttMorisPratt knuttMorisPratt = new KnuttMorisPratt();

        knuttMorisPratt.KMPSearch("AABA", "AABAACAADAABAAABAA");
        knuttMorisPratt.KMPSearch("ABABCABAB", "ABABDABACDABABCABAB");
        knuttMorisPratt.lps("AAACAAAA");
        knuttMorisPratt.lps("AABAACAABAA");
        knuttMorisPratt.lps("ABCDE");
        knuttMorisPratt.lps("AAAAA");
        knuttMorisPratt.lps("AAABAAA");
    }
}
