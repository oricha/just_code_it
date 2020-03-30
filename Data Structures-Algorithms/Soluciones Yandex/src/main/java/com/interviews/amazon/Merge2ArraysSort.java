package com.interviews.amazon;

import java.util.Arrays;

public class Merge2ArraysSort {

	public static void main(String[] args) {
		int[] a = { 4, 7, 2, 9, 12, 35, 8, 49 };
		int[] b = { 24, 53, 6, 19, 41, 71, 1, 68, 11, 32, 99 };
		 int[] result = mergeSortArrays(a, b);
		 //TODO fix this   ********************
		 Arrays.sort(result);
		System.out.println(Arrays.toString(result));
	}

	private static int[] mergeSortArrays(int[] a, int[] b) {
		int[] answer = new int[a.length + b.length];
		int i = a.length - 1, j = b.length - 1, k = answer.length;

		while (k > 0)
			answer[--k] = (j < 0 || (i >= 0 && a[i] >= b[j])) ? a[i--] : b[j--];
		return answer;
	}

}
//
// int[] answer = new int[a.length + b.length];
// int i = 0, j = 0, k = 0;
//
// while (i < a.length && j < b.length) {
// if (a[i] < b[j])
// answer[k++] = a[i++];
//
// else
// answer[k++] = b[j++];
// }
//
// while (i < a.length)
// answer[k++] = a[i++];
//
// while (j < b.length)
// answer[k++] = b[j++];
