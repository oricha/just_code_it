package com.codility.tomtom;

public class ReverseLineString {

	
	public static String solution(String S) {
		String[] array = S.split("\\s+");
		
		for(int i = 0; i<array.length; i++){
			array[i] = reverse(array[i]);
		}
		return String.join(" ", array);
    }
	
	private static String reverse(String str){
		return new StringBuilder(str).reverse().toString();
	}
}
