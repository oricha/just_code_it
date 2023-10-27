import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String n = in.nextLine();
		System.out.println(solution(n));

	}

	private static String solution(String S) {

		// String[] numbers = S.split("[-\\s]");

		char[] numbers = S.toCharArray();
		StringBuffer result = new StringBuffer();
		int count = 0;

		for (char n : numbers) {
			if (n != '-' && n != ' ') {
				if (count % 3 == 0 && count != 0) {
					result.append("-");
				}
				result.append(n);
				count++;
			}
		}
		return result.toString();
	}

	// var s = "00-44  48 5555 8361";
	// var n = s.replace(/\D/g,'');
	// var temp = formatNumber(n);
	// var final = temp.replace(/\-$/,'');
	// alert(final);
	//
	// function formatNumber(S){
	// var len = S.length;
	// var max = len - 2 * ((3-len) % 3);
	// var dash = "-";
	// var result;
	// for(i = 0; i < max; i+=3){
	// result += S.substring(i, i+3).concat(dash);
	// }
	// for(i = max; i < len; i+=2){
	// result += S.substring(i, i+2).concat(dash);
	// }
	// return result.toString();
	// }

}
