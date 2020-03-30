package com.interviews.amazon;

import java.util.Scanner;

/**
 * A number ending with 3 will have a multiple which is all 1. Eg­ multiple of 3
 * is 111 and of 13 is 111111. Given a number ending with 3 find its least
 * multiple which is all 1. The 2 multiple of the given number can be beyond the
 * range of int,long etc. Optimize for time.
 * 
 * @author Zion
 *
 */

//TODO  fix this
public class Magic3 {
	/**
	 * A x B = XXX3
	 */
	static long MAX = Long.MAX_VALUE;
	public static int magic3(int number) {

		for (int i = 2; i < MAX - 1; i++) {
			if ((i % number == 0) && is1(i)) {
				return i;
			}
		}
		return 0;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		magic3(n);
	}

	public static boolean is1(int check) {

		char[] chars = String.valueOf(check).toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != 1) {
				return false;
			}
		}
		return true;
	}

}
