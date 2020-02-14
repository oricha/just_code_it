package com.codility.tomtom;

public class Solution3 {

	public int solution(int[] A) {
		// write your code in Java SE 8

		boolean[] visited = new boolean[A.length];
		int index = 0;
		int steps = 0;

		while (!visited[index]) {
			visited[index] = true; // mark index as visited
			index = A[index]; // go to the next index
			steps++; // count this step
		}
	
		// result = Length - visited.count	
		return 0;
	}
}
