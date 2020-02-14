package com.codility;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 String str = in.nextLine();
		 System.out.println("Is Palindrome :"+ isPalindrome(str));
	}
	private static boolean isPalindrome(String str) {

		int n = str.length();
		for (int i = 0; i < (n / 2); i++) {
			if (str.charAt(i) != str.charAt(n - i - 1)) {
				return false;
			}
		}
		return true;
	}

}
