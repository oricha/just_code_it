/**
 * Break into spaces Write a program that breaks up a string of words with no
 * spaces into a string with the appropriate spaces An algorithm that takes in
 * input a string of words without spaces, and return a string with spaces.
 * 
 * Video google interview https://www.youtube.com/watch?v=oWbUtlUhwa8
 * 
 * @author Zion
 *
 */
public class StringToWords {

	public static String breakIntoSpaces(String source) {

		for (int i = 1; i < source.length(); i++) {
			String left = source.substring(0, i);
			String right = source.substring(i, source.length());

			if (DICTIONARY.contains(left)) {
				String breakRight = breakIntoSpaces(right);
				if (!right.equals(breakRight)) {
					return left + " " + right;
				}
			}
		}
		return source;
	}

	public static void main(String[] args) {

		String str = "estoesunapalabramuylargaquesesuponesedebeseparar";
		System.out.println(breakIntoSpaces(str));
	}

	public static class DICTIONARY {

		public static boolean contains(String left) {
			// TODO Mock function. Generate random boolean
			return Math.random() < 0.5;
		}

	}

};