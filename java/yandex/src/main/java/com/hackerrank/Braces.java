package com.hackerrank;

import java.util.Stack;

/**
 * Problem Statement Braces in a string are considered to be balanced if the
 * following criteria are met: For every opening brace (i.e.: ( , { , or [ ),
 * there is a matching closing brace (i.e.: ) , } , or ] ) of the same type
 * (i.e.: ( matches ) , { matches } , and [ matches ] ). An opening brace must
 * appear before (to the left of) its matching closing brace (e.g.: ]{}[ is not
 * balanced ). No unmatched braces lie between some pair of matched braces. For
 * example, ({[]}) is balanced , but {[}] and [{)] are not balanced . Complete
 * the Braces function in your editor. This function should take an array of
 * strings named values as a parameter, determine if all its braces are
 * balanced, and then return an array of strings indicating whether the string
 * in the corresponding index of the original array was balanced. If the string
 * in values[i] (where 0 ≤ i ≤ length of values - 1) has balanced braces, then
 * index i in the return array should contain the string YES ; otherwise, index
 * i in the return array should contain the string NO . Constraints 1 ≤ length
 * of values ≤ 15 1 ≤ length of string ≤ 100 Sample Input values = { "{}[]()" ,
 * "{[}]" } Sample Output return = { "YES" , "NO" } Explanation values[0]:
 * {}[]() meets the criterion for a balanced string, so index 0 in our return
 * array should contain the string YES . values[1]: {[}] contains unmatched
 * braces between a matched pair (in the substrings [} , {[} , and [}] ), so
 * index 1 in our return array should contain the string NO .
 * 
 * @author Zion
 *
 */
public class Braces {

	static boolean checkBalance(String str) {
		Stack<Character> javaStack = new Stack<Character>();
		for (char brace : str.toCharArray()) {
			switch (brace) {
			case '{':
			case '(':
			case '[':
				javaStack.push(brace);
				break;
			case '}':
				if (javaStack.isEmpty() || javaStack.pop() != '{')
					return false;
				break;
			case ')':
				if (javaStack.isEmpty() || javaStack.pop() != '(')
					return false;
				break;
			// TODO
			case ']':
				if (javaStack.isEmpty() || javaStack.pop() != '[')
					return false;
				break;
			}
		}
		return javaStack.isEmpty();
	}

	static String[] Braces(String[] values) {
		String[] result = new String[values.length];
		int i = 0;
		for (String str : values) {
			if (checkBalance(str)) {
				result[i] = "YES";
			} else {
				result[i] = "NO";
			}
			i++;
		}
		return result;
	}

}
